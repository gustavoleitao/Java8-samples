package br.com.logique.java8.functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Gustavo on 19/11/2015.
 */
public class ConsumerExemplo implements Runnable {


    public void imprimir1(){
        List<String> nomes = Arrays.asList("Ozama nas alturas", "Coroinha", "Felipe Ibyte");
        nomes.stream().forEach(new ConsumerTest());
    }

    public void imprimir2(){
        List<String> nomes = Arrays.asList("Ozama nas alturas", "Coroinha", "Felipe Ibyte");
        nomes.stream().forEach(nome -> System.out.println(nome));
    }

    @Override
    public void run() {
        imprimir1();
        System.out.println("---------------------------------");
        imprimir2();
    }

    private class ConsumerTest implements Consumer<String>{

        @Override
        public void accept(String param) {
            System.out.println(param);
        }
    }

    public static void main(String[] args) {
        ExecucaoInstrumentada execucaoInstrumentada = new ExecucaoInstrumentada();
        Runnable consumerExemplo =  new ConsumerExemplo();
        execucaoInstrumentada.accept(consumerExemplo);
    }

}
