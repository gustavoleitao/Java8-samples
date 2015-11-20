package br.com.logique.java8.functional;

import java.util.function.DoubleFunction;
import java.util.function.Function;

/**
 * Created by Gustavo on 19/11/2015.
 */
public class FunctionExemplo implements Runnable {

    @Override
    public void run() {
        Function<Double,Double>  pow2 = (input) -> Math.pow(input,2);
        Function<Double,Double> seno = (input) -> Math.sin(input);

        double valor = Math.PI;
        double result = pow2.andThen(seno).apply(valor);
        System.out.println(" o seno de "+ valor +" ao quadrado eh "+result);
    }

    public static void main(String[] args) {
        ExecucaoInstrumentada execucaoInstrumentada = new ExecucaoInstrumentada();
        Runnable supplierExemplo = new FunctionExemplo();
        execucaoInstrumentada.accept(supplierExemplo);
    }

}
