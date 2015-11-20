package br.com.logique.java8.stream;

import br.com.logique.java8.functional.ExecucaoInstrumentada;
import br.com.logique.java8.util.Cidade;
import br.com.logique.java8.util.PrintUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Exemplos de utilização de filtros.
 *
 * Created by Gustavo on 20/11/2015.
 */
public class Stream07 implements Runnable {

    private List<Cidade> getCidadesDistintas() {
        Cidade city1 = new Cidade(1L, "SP", "Sao Paulo", 11316149L, Arrays.asList("Av. Paulista", "Av. Reboucas"));
        Cidade city2 = new Cidade(2L, "RJ", "Rio de Janeiro", 6323037L, Arrays.asList("Av. Brasil"));
        Cidade city3 = new Cidade(3L, "SP", "Campinas", 1098630L, Arrays.asList("Av. Brasil"));
        Cidade city4 = new Cidade(4L, "MG", "Uberaba", 302623L, Arrays.asList("Av. Leopoldina"));
        Cidade city5 = new Cidade(5L, "RN", "Natal", 862044L, Arrays.asList("Rua Sinval Moreira Dias"));
        return Arrays.asList(city1, city2, city3, city4, city5);
    }

    public void exemplo01(){
        List<Cidade> cidadesMaisMeioMilhao = getCidadesDistintas().stream().filter(cidade -> cidade.getPopulation() > 500000L).collect(Collectors.toList());
        PrintUtil.print(cidadesMaisMeioMilhao);
    }

    public void exemplo02(){
        List<String> cidadesSP = getCidadesDistintas().stream()
                .filter(cidade -> cidade.getState().equals("SP"))
                .map(Cidade::getName).collect(Collectors.toList());
        PrintUtil.print(cidadesSP);
    }

    @Override
    public void run() {
        exemplo01();
        exemplo02();
    }

    public static void main(String[] args) {
        ExecucaoInstrumentada execucaoInstrumentada = new ExecucaoInstrumentada();
        Runnable supplierExemplo = new Stream07();
        execucaoInstrumentada.accept(supplierExemplo);
    }

}
