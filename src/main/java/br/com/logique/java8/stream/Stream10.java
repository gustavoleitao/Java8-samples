package br.com.logique.java8.stream;

import br.com.logique.java8.functional.ExecucaoInstrumentada;
import br.com.logique.java8.util.Cidade;
import br.com.logique.java8.util.PrimoPredicado;
import br.com.logique.java8.util.PrintUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Paralelização de streams.
 *
 * Created by Gustavo on 20/11/2015.
 */
public class Stream10 implements Runnable {

    private List<Cidade> getCidadesDistintas() {
        Cidade city1 = new Cidade(1L, "SP", "Sao Paulo", 11316149L, Arrays.asList("Av. Paulista", "Av. Reboucas"));
        Cidade city2 = new Cidade(2L, "RJ", "Rio de Janeiro", 6323037L, Arrays.asList("Av. Brasil"));
        Cidade city3 = new Cidade(3L, "SP", "Campinas", 1098630L, Arrays.asList("Av. Brasil"));
        Cidade city4 = new Cidade(4L, "MG", "Uberaba", 302623L, Arrays.asList("Av. Leopoldina"));
        Cidade city5 = new Cidade(5L, "RN", "Natal", 862044L, Arrays.asList("Rua Sinval Moreira Dias"));
        return Arrays.asList(city1, city2, city3, city4, city5);
    }

    private void exemplo01(){
        Set<String> statesWithLargestCities =
                getCidadesDistintas().stream()
                        .parallel().filter(e -> e.getPopulation() > 1000000) // Filtro irá ser feito em paralelo
                        .sequential().map(Cidade::getState).collect(Collectors.toSet()); // Map será feito sequencialmente
        PrintUtil.print(statesWithLargestCities);
    }


    /**
     * Calcula os primo de 1 a 10 milhoes sequencialmente
     */
    private void exemplo02(){
        Stream<Integer> stream = Stream.iterate(1, n -> n++).limit(10000000);
        long qntPrimos = stream.filter(new PrimoPredicado()).mapToLong(Integer::intValue).count();
        System.out.println("Quatidade primos="+qntPrimos);
    }

    /**
     * Calcula os primo de 1 a 10 milhoes paralalamente
     */
    private void exemplo03(){
        Stream<Integer> stream = Stream.iterate(1, n -> n++).limit(10000000);
        long qntPrimos = stream.parallel().filter(new PrimoPredicado()).sequential().mapToLong(Integer::intValue).count();
        System.out.println("Quatidade primos="+qntPrimos);
    }


    @Override
    public void run() {
        exemplo01();
        //exemplo02();
        //exemplo03();
    }

    public static void main(String[] args) {
        ExecucaoInstrumentada execucaoInstrumentada = new ExecucaoInstrumentada();
        Runnable supplierExemplo = new Stream10();
        execucaoInstrumentada.accept(supplierExemplo);
    }

}
