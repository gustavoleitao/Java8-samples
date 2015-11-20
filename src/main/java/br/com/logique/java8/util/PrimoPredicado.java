package br.com.logique.java8.util;

import java.util.function.Predicate;

/**
 * Created by Gustavo on 20/11/2015.
 */
public class PrimoPredicado implements Predicate<Integer> {

    @Override
    public boolean test(Integer integer) {
        return isPrimo(integer);
    }

    boolean isPrimo(int n) {
        if (n%2==0) return false;
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }
}


