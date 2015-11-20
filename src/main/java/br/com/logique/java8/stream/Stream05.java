package br.com.logique.java8.stream;

import br.com.logique.java8.functional.ExecucaoInstrumentada;
import br.com.logique.java8.util.Cidade;
import br.com.logique.java8.util.PrintUtil;

import java.util.Arrays;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Exenmplos de estatísticas.
 *
 * Created by Gustavo on 19/11/2015.
 */
public class Stream05 implements Runnable {

    private static final String END_LINE = "\n";

    private List<Cidade> getCidadesDistintas() {
        Cidade city1 = new Cidade(1L, "SP", "Sao Paulo", 11316149L, Arrays.asList("Av. Paulista", "Av. Reboucas"));
        Cidade city2 = new Cidade(2L, "RJ", "Rio de Janeiro", 6323037L, Arrays.asList("Av. Brasil"));
        Cidade city3 = new Cidade(3L, "SP", "Campinas", 1098630L, Arrays.asList("Av. Brasil"));
        Cidade city4 = new Cidade(4L, "MG", "Uberaba", 302623L, Arrays.asList("Av. Leopoldina"));
        Cidade city5 = new Cidade(5L, "RN", "Natal", 862044L, Arrays.asList("Rua Sinval Moreira Dias"));
        return Arrays.asList(city1, city2, city3, city4, city5);
    }

    private void exemplo01(){
        LongSummaryStatistics summary = getCidadesDistintas().stream()
                .collect(Collectors.summarizingLong(c -> c.getPopulation()));

        StringBuilder stat = new StringBuilder();
        stat.append("count=").append(summary.getCount()).append(END_LINE);
        stat.append("sum=").append(summary.getSum()).append(END_LINE);
        stat.append("min=").append(summary.getMin()).append(END_LINE);
        stat.append("max=").append(summary.getMax()).append(END_LINE);
        stat.append("avg=").append(summary.getAverage());
        PrintUtil.print(stat.toString());
    }

    @Override
    public void run() {
        exemplo01();
    }

    public static void main(String[] args) {
        ExecucaoInstrumentada execucaoInstrumentada = new ExecucaoInstrumentada();
        Runnable supplierExemplo = new Stream05();
        execucaoInstrumentada.accept(supplierExemplo);
    }

}
