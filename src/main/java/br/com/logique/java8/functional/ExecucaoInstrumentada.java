package br.com.logique.java8.functional;

import org.slf4j.profiler.Profiler;

import java.util.function.Consumer;

/**
 * Created by Gustavo on 19/11/2015.
 */
public class ExecucaoInstrumentada implements Consumer<Runnable> {

    @Override
    public void accept(Runnable runnable) {
        Profiler profiler = new Profiler("profiler");
        profiler.start(runnable.getClass().getSimpleName());
        runnable.run();
        System.out.println();
        profiler.stop().print();
    }
}
