package br.com.logique.java8.stream;

import br.com.logique.java8.functional.ExecucaoInstrumentada;
import br.com.logique.java8.util.PrimoPredicado;
import br.com.logique.java8.util.PrintUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Buscas em streams.
 * Created by Gustavo on 20/11/2015.
 */
public class Stream11 implements Runnable {

    private void exemplo01() {
        List<String> characters = Arrays.asList("Mario", "Luigi", "Yoshi", "Toad");
        Optional<String> nameStartingWithL = characters.stream().filter(e -> e.startsWith("L")).findFirst();
        nameStartingWithL.ifPresent(System.out::println);
    }

    private void exemplo02() {
        Stream<Integer> stream = Stream.iterate(1, n -> n++).limit(10000000);
        Optional<Integer> optional = stream.filter(new PrimoPredicado()).findFirst();
        optional.ifPresent(System.out::println);
    }

    private void exemplo03() {
        Stream<Integer> stream = Stream.iterate(1, n -> n++).limit(10000000);
        Optional<Integer> optional = stream.parallel().filter(new PrimoPredicado()).findAny();
        optional.ifPresent(System.out::println);
    }

    private void exemplo04() {
        Stream<Integer> stream = Stream.iterate(1, n -> n++).limit(10000000);
        boolean existePar = stream.parallel().anyMatch(v -> v % 2 == 0);
        PrintUtil.print(existePar);
    }

    private void exemplo05() {
        Stream<Integer> stream = Stream.iterate(1, n -> n++).limit(10000000);
        boolean existePar = stream.filter(v -> v % 2 != 0).anyMatch(v -> v % 2 == 0);
        PrintUtil.print(existePar);
    }


    @Override
    public void run() {
        //exemplo01();
        //exemplo02();
        //exemplo03();
        //exemplo04();
        exemplo05();
    }

    public static void main(String[] args) {
        ExecucaoInstrumentada execucaoInstrumentada = new ExecucaoInstrumentada();
        Runnable supplierExemplo = new Stream11();
        execucaoInstrumentada.accept(supplierExemplo);
    }

}
