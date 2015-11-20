package br.com.logique.java8.stream;

import br.com.logique.java8.functional.ExecucaoInstrumentada;
import br.com.logique.java8.util.PrintUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Exemplo de alguns cuidados com Stream e dicas de debug.
 *
 * Created by Gustavo on 20/11/2015.
 */
public class Stream08 implements Runnable{

    /**
     * Cuidado se o stream já tiver tido um operador final não pode ser reutilizado.
     */
    public void exemplo01(){
        Stream<String> stream = Stream.of("Mario", "Luigi", "Yoshi", "Toad");
        stream.forEach(e -> System.out.print(e.toLowerCase() + " "));
        stream.forEach(e -> System.out.print(e.toLowerCase() + " "));
    }

    public void exemplo02(){
        List<String> characters = Arrays.asList("Mario", "Luigi", "Yoshi", "Toad");
        characters.stream()
                .peek(e -> System.out.print(e.toLowerCase() + " "))
                .peek(e -> System.out.print(e.toUpperCase() + " "))
                .forEach(e -> System.out.print("(" + e + ") "));
        System.out.println();
    }

    public void exemplo03(){
        List<String> characters = Arrays.asList("Mario", "Luigi", "Yoshi", "Toad");
        characters.stream()
                .filter(e -> e.length() > 4)
                .peek(e -> System.out.print("f(" + e + ") "))
                .map(String::toUpperCase)
                .peek(e -> System.out.print("m(" + e + ") "))
                .collect(Collectors.toList());
    }

    @Override
    public void run() {
        //exemplo01();
        exemplo02();
        exemplo03();
    }

    public static void main(String[] args) {
        ExecucaoInstrumentada execucaoInstrumentada = new ExecucaoInstrumentada();
        Runnable supplierExemplo = new Stream08();
        execucaoInstrumentada.accept(supplierExemplo);
    }


}
