package br.com.logique.java8.stream;

import br.com.logique.java8.functional.ExecucaoInstrumentada;
import br.com.logique.java8.util.PrintUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Exemplo de formas de criação de streams.
 *
 * Created by Gustavo on 19/11/2015.
 */
public class Stream01 implements Runnable {

    private void exemplo01(){
        List<String> nomes = new ArrayList<String>();
        nomes.add("Ozama nas alturas");
        nomes.add("Coroinha");
        nomes.add("Felipe Ibyte");

        Stream<String> stream = nomes.stream();
        PrintUtil.print(stream);
    }

    private void exemplo02(){
        Stream<String> stream = Stream.of("po", "li", "a", "na");
        PrintUtil.print(stream);
    }

    private void exemplo03(){
        Stream<Double> stream = Stream.generate(Math::random).limit(5);
        PrintUtil.print(stream);
    }

    private void exemplo04(){
        Stream<Double> stream = Stream.iterate(0d, n -> n + 3).limit(5);
        PrintUtil.print(stream);
    }

    private void exemplo05(){
        Stream<String> stream = Stream.of("eu", "eu", "sou", "sou","ga", "ga", "ga", "go");
        stream = stream.distinct();
        PrintUtil.print(stream);
    }

    private void exemplo06(){
        Stream<String> stream = Stream.of("zumbido", "vixe", "eish", "amianto");
        stream = stream.sorted();
        PrintUtil.print(stream);
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
        Runnable supplierExemplo = new Stream01();
        execucaoInstrumentada.accept(supplierExemplo);
    }

}
