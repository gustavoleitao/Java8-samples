package br.com.logique.java8.stream;

import br.com.logique.java8.functional.ExecucaoInstrumentada;
import br.com.logique.java8.util.PrintUtil;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Exemplo de formas de coletar uma stream.
 *
 * Created by Gustavo on 19/11/2015.
 */
public class Stream02 implements Runnable {

    private void exemplo01(){
        Stream<String> stream = Stream.of("mario", "Mario", "luigi", "Luigi", "Yoshi", "Toad", "Toad");
        List<String> list = stream.collect(Collectors.toList());
        PrintUtil.print(list);
    }

    private void exemplo02(){
        Stream<String> stream = Stream.of("mario", "Mario", "luigi", "Luigi", "Yoshi", "Toad", "Toad");
        Set<String> list = stream.collect(Collectors.toSet());
        PrintUtil.print(list);
    }

    private void exemplo03(){
        List<String> nomes = Arrays.asList("mario", "Mario", "luigi", "Luigi", "Yoshi", "Toad", "Toad");
        Map<String, Integer> map = nomes.stream().distinct().collect(Collectors.toMap(String::toString, String::length));
        PrintUtil.print(map);
    }

    private void exemplo04(){
        List<String> nomes = Arrays.asList("mario", "Mario", "luigi", "Luigi", "Yoshi", "Toad", "Toad");
        Map<String, Integer> map = nomes.stream().distinct().collect(Collectors.toMap((p->p.toString()), (p) -> p.hashCode()));
        PrintUtil.print(map);
    }

    private void exemplo05(){
        List<String> nomes = Arrays.asList("mario", "Mario", "luigi", "Luigi", "Yoshi", "Toad", "Toad");
        //SUPPLIER
        Set<String> result = nomes.stream().collect(Collectors.toCollection(TreeSet::new));
        PrintUtil.print(result);
    }

    private void exemplo06(){
        List<String> nomes = Arrays.asList("mario", "Mario", "luigi", "Luigi", "Yoshi", "Toad", "Toad");
        //SUPPLIER, ACCUMULATOR, COMBINER
        Set<String> result = nomes.stream().collect(HashSet::new, HashSet::add, HashSet::addAll);
        PrintUtil.print(result);
    }

    @Override
    public void run() {
        exemplo01();
        exemplo02();
        exemplo03();
        exemplo04();
        exemplo05();
        exemplo06();
    }

    public static void main(String[] args) {
        ExecucaoInstrumentada execucaoInstrumentada = new ExecucaoInstrumentada();
        Runnable supplierExemplo = new Stream02();
        execucaoInstrumentada.accept(supplierExemplo);
    }


}
