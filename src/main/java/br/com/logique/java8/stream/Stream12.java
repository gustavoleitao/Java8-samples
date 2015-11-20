package br.com.logique.java8.stream;

import br.com.logique.java8.functional.ExecucaoInstrumentada;
import br.com.logique.java8.util.PrintUtil;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Exemplos de streams primitivos.
 *
 * Created by Gustavo on 20/11/2015.
 */
public class Stream12 implements Runnable{

    private void exemplo01() {
        IntStream primes = IntStream.of(1, 2, 3, 5, 7);
        PrintUtil.print(Arrays.toString(primes.toArray()));
    }

    private void exemplo02() {
        int[] values = {1, 2, 3, 5, 7};
        IntStream primes = Arrays.stream(values, 0, 3); //range do array
        PrintUtil.print(Arrays.toString(primes.toArray()));
    }

    private void exemplo03() {
        IntStream zeroToNine = IntStream.range(0, 10);
        PrintUtil.print(Arrays.toString(zeroToNine.toArray()));
    }

    private void exemplo04() {
        IntStream zeroToNine = IntStream.rangeClosed(0, 10);
        PrintUtil.print(Arrays.toString(zeroToNine.toArray()));
    }

    private void exemplo05() {
        Stream<String> stream = Stream.of("Mario", "Luigi", "Yoshi", "Toad");
        IntStream lengths = stream.mapToInt(String::length);
        PrintUtil.print(Arrays.toString(lengths.toArray()));
    }

    @Override
    public void run() {
        exemplo01();
        exemplo02();
        exemplo03();
        exemplo04();
        exemplo05();
    }


    public static void main(String[] args) {
        ExecucaoInstrumentada execucaoInstrumentada = new ExecucaoInstrumentada();
        Runnable supplierExemplo = new Stream12();
        execucaoInstrumentada.accept(supplierExemplo);
    }

}
