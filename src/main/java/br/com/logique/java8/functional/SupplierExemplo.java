package br.com.logique.java8.functional;

import java.time.LocalDateTime;
import java.util.function.Supplier;

/**
 * Created by Gustavo on 19/11/2015.
 */
public class SupplierExemplo implements Runnable {

    @Override
    public void run() {
        Supplier<LocalDateTime> supplier = LocalDateTime::now;
        System.out.println(supplier.get());
    }

    public static void main(String[] args) {
        ExecucaoInstrumentada execucaoInstrumentada = new ExecucaoInstrumentada();
        Runnable supplierExemplo = new SupplierExemplo();
        execucaoInstrumentada.accept(supplierExemplo);
    }

}
