package br.com.logique.java8.stream;

import br.com.logique.java8.functional.ExecucaoInstrumentada;
import br.com.logique.java8.util.Cidade;
import br.com.logique.java8.util.PrintUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Exemplo de operações com map e flatmap.
 * Created by Gustavo on 20/11/2015.
 */
public class Stream06 implements Runnable {

    private List<Cidade> getCidadesDistintas() {
        Cidade city1 = new Cidade(1L, "SP", "Sao Paulo", 11316149L, Arrays.asList("Av. Paulista", "Av. Reboucas"));
        Cidade city2 = new Cidade(2L, "RJ", "Rio de Janeiro", 6323037L, Arrays.asList("Av. Brasil"));
        Cidade city3 = new Cidade(3L, "SP", "Campinas", 1098630L, Arrays.asList("Av. Brasil"));
        Cidade city4 = new Cidade(4L, "MG", "Uberaba", 302623L, Arrays.asList("Av. Leopoldina"));
        Cidade city5 = new Cidade(5L, "RN", "Natal", 862044L, Arrays.asList("Rua Sinval Moreira Dias"));
        return Arrays.asList(city1, city2, city3, city4, city5);
    }

    public void exemplo01(){
        List<List<String>> mappedStreets =
                getCidadesDistintas().stream().map(city -> city.getStreets()).collect(Collectors.toList());
        PrintUtil.print(mappedStreets);
    }

    public void exemplo02(){
        Set<String> mappedEstados =
                getCidadesDistintas().stream().flatMap(city -> Stream.of(city.getState())).collect(Collectors.toSet());
        PrintUtil.print(mappedEstados);
    }

    public void exemplo03(){
        long populacao =
                getCidadesDistintas().stream().mapToLong(city -> city.getPopulation()).sum();
        PrintUtil.print("Populacao total="+populacao);
    }

    public void exemplo04(){
        Set<String> mappedRuas =
                getCidadesDistintas().stream().flatMap(city -> city.getStreets().stream()).collect(Collectors.toSet());
        PrintUtil.print(mappedRuas);
    }

    @Override
    public void run() {
        exemplo01();
        exemplo02();
        exemplo03();
        exemplo04();
    }

    public static void main(String[] args) {
        ExecucaoInstrumentada execucaoInstrumentada = new ExecucaoInstrumentada();
        Runnable supplierExemplo = new Stream06();
        execucaoInstrumentada.accept(supplierExemplo);
    }

}
