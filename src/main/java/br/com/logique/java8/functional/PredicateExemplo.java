package br.com.logique.java8.functional;

import java.io.File;
import java.util.function.Predicate;

/**
 * Verifica se um valor é par.
 *
 * Created by Gustavo on 19/11/2015.
 */
public class PredicateExemplo implements Runnable {

    @Override
    public void run() {
        Predicate<Integer> predicate = x -> ((x % 2) == 0);
        int valor = 10;
        System.out.println(valor+" eh par? " +predicate.test(valor));
    }

    public static void main(String[] args) {
        ExecucaoInstrumentada execucaoInstrumentada = new ExecucaoInstrumentada();
        Runnable supplierExemplo = new PredicateExemplo();
        execucaoInstrumentada.accept(supplierExemplo);
    }

}
