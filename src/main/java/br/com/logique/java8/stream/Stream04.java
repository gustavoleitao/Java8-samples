package br.com.logique.java8.stream;

import br.com.logique.java8.functional.ExecucaoInstrumentada;
import br.com.logique.java8.util.Cidade;
import br.com.logique.java8.util.PrintUtil;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Exemplos de coleta de String em map.
 * Created by Gustavo on 19/11/2015.
 */
public class Stream04 implements Runnable {

    private List<Cidade> getCidadesDistintas() {
        Cidade city1 = new Cidade(1L, "SP", "Sao Paulo", 11316149L, Arrays.asList("Av. Paulista", "Av. Reboucas"));
        Cidade city2 = new Cidade(2L, "RJ", "Rio de Janeiro", 6323037L, Arrays.asList("Av. Brasil"));
        Cidade city3 = new Cidade(3L, "SP", "Campinas", 1098630L, Arrays.asList("Av. Brasil"));
        Cidade city4 = new Cidade(4L, "MG", "Uberaba", 302623L, Arrays.asList("Av. Leopoldina"));
        Cidade city5 = new Cidade(5L, "RN", "Natal", 862044L, Arrays.asList("Rua Sinval Moreira Dias"));
        return Arrays.asList(city1, city2, city3, city4, city5);
    }

    private List<Cidade> getCidadesConflito() {
        Cidade city1 = new Cidade(1L, "SP", "Sao Paulo", 11316149L, Arrays.asList("Av. Paulista", "Av. Reboucas"));
        Cidade city2 = new Cidade(2L, "RJ", "Rio de Janeiro", 6323037L, Arrays.asList("Av. Brasil"));
        Cidade city3 = new Cidade(3L, "SP", "Campinas", 1098630L, Arrays.asList("Av. Brasil"));
        Cidade city4 = new Cidade(4L, "MG", "Uberaba", 302623L, Arrays.asList("Av. Leopoldina"));
        Cidade city5 = new Cidade(4L, "RN", "Natal", 862044L, Arrays.asList("Rua Sinval Moreira Dias"));
        return Arrays.asList(city1, city2, city3, city4, city5);
    }

    private void exemplo01(){
        Map<Long, String> nomePorId = getCidadesDistintas().stream()
                .collect(Collectors.toMap(Cidade::getId, Cidade::getName));
        PrintUtil.print(nomePorId);
    }

    private void exemplo02(){
        Map<Long, Cidade> cidadesPorIdMap =  getCidadesDistintas().stream()
                .collect(Collectors.toMap(Cidade::getId, Function.identity()));
        PrintUtil.print(cidadesPorIdMap);
    }

    /**
     * Prover uma função para resolver conflitos quando possui chaves iguais.
     * Nesse exemplo a segunda será mantida.
     */
    private void exemplo03(){
        TreeMap<Long, Cidade> cidadesPorIdTreeMap = getCidadesConflito().stream()
                .collect(Collectors.toMap(Cidade::getId, Function.identity(), (v1, v2) -> v2, TreeMap::new));
        PrintUtil.print(cidadesPorIdTreeMap);
    }

    private void exemplo04(){
        Map<String, List<Cidade>> cidadesPorEstado =
                getCidadesDistintas().stream().collect(Collectors.groupingBy(Cidade::getState));
        PrintUtil.print(cidadesPorEstado);
    }

    private void exemplo05(){
        Map<String, Set<Cidade>> setCidadePorEstado =
                getCidadesDistintas().stream().collect(Collectors.groupingBy(Cidade::getState, Collectors.toSet()));
        PrintUtil.print(setCidadePorEstado);
    }

    private void exemplo06(){
        Map<Boolean, List<Cidade>> spCidadesEoutras =
                getCidadesDistintas().stream().collect(Collectors.partitioningBy(e -> e.getState().equals("SP")));
        PrintUtil.print(spCidadesEoutras);
    }

    private void exemplo07(){
        Map<String, Long> cityCountByState = getCidadesDistintas().stream().collect(
                Collectors.groupingBy(Cidade::getState, Collectors.counting()));
        PrintUtil.print(cityCountByState);
    }

    private void exemplo08(){
        Map<String, Long> populationByState = getCidadesDistintas().stream().collect(
                Collectors.groupingBy(Cidade::getState, Collectors.summingLong(Cidade::getPopulation)));
        PrintUtil.print(populationByState);
    }

    private void exemplo09(){
        Map<String, Optional<Cidade>> largestCityByState = getCidadesDistintas().stream().collect(
                Collectors.groupingBy(Cidade::getState, Collectors.maxBy(Comparator.comparing(Cidade::getPopulation))));
        PrintUtil.print(largestCityByState);
    }

    private void exemplo10(){
        Map<String, Optional<Cidade>> smallestCityByState = getCidadesDistintas().stream().collect(
                Collectors.groupingBy(Cidade::getState, Collectors.minBy(Comparator.comparing(Cidade::getPopulation))));
        PrintUtil.print(smallestCityByState);
    }

    private void exemplo11(){
        Map<String, String> cityNamesByState = getCidadesDistintas().stream().collect(
                Collectors.groupingBy(Cidade::getState, Collectors.mapping(Cidade::getName, Collectors.joining(", "))));
        PrintUtil.print(cityNamesByState);
    }

    @Override
    public void run() {
        exemplo01();
        exemplo02();
        exemplo03();
        exemplo04();
        exemplo05();
        exemplo06();
        exemplo07();
        exemplo08();
        exemplo09();
        exemplo10();
        exemplo11();
    }

    public static void main(String[] args) {
        ExecucaoInstrumentada execucaoInstrumentada = new ExecucaoInstrumentada();
        Runnable supplierExemplo = new Stream04();
        execucaoInstrumentada.accept(supplierExemplo);
    }

}


