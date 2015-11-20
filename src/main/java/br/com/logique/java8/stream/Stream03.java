package br.com.logique.java8.stream;

import br.com.logique.java8.functional.ExecucaoInstrumentada;
import br.com.logique.java8.util.PrintUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Exemplos de operações com String em streams.
 *
 * Created by Gustavo on 19/11/2015.
 */
public class Stream03 implements Runnable {

    private void exemplo01(){
        List<String> characters = Arrays.asList("Mario", "Luigi", "Yoshi", "Toad");
        String result = characters.stream().collect(Collectors.joining());
        PrintUtil.print(result);
    }

    private void exemplo02(){
        List<String> characters = Arrays.asList("Mario", "Luigi", "Yoshi", "Toad");
        String result = characters.stream().collect(Collectors.joining(", "));
        PrintUtil.print(result);
    }

    private void exemplo03(){
        Stream<Double> stream = Stream.iterate(0d, n -> n + 3).limit(5);
        String result = stream.map(Object::toString).collect(Collectors.joining(", "));
        PrintUtil.print(result);
    }

    @Override
    public void run() {
        exemplo01();
        exemplo02();
        exemplo03();
    }

    public static void main(String[] args) {
        ExecucaoInstrumentada execucaoInstrumentada = new ExecucaoInstrumentada();
        Runnable supplierExemplo = new Stream03();
        execucaoInstrumentada.accept(supplierExemplo);
    }

}
