package br.com.logique.java8.stream;

import br.com.logique.java8.functional.ExecucaoInstrumentada;
import br.com.logique.java8.util.PrintUtil;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by Gustavo on 20/11/2015.
 */
public class Stream09 implements Runnable {

    public void exemplo01(){
        Optional<Integer> sum = Stream.of(1, 2, 3, 4).reduce((x, y) -> x + y);
        // e1 + e2 + e3 + ...
        PrintUtil.print(sum.orElse(0));
    }

    public void exemplo02(){
        Integer sum = Stream.of(1, 2, 3, 4).reduce(0, (x, y) -> x + y);
        // 0 + e1 + e2 + e3 + ...
        PrintUtil.print(sum);
    }

    public void exemplo03(){
        Integer product = Stream.of(1, 2, 3, 4).reduce(1, (x, y) -> x * y);
        // 1 * e1 * e2 * e3 * ...
        PrintUtil.print(product);
    }

    @Override
    public void run() {
        exemplo01();
        exemplo02();
        exemplo03();
    }

    public static void main(String[] args) {
        ExecucaoInstrumentada execucaoInstrumentada = new ExecucaoInstrumentada();
        Runnable supplierExemplo = new Stream09();
        execucaoInstrumentada.accept(supplierExemplo);
    }

}
