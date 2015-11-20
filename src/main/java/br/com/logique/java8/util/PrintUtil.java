package br.com.logique.java8.util;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Utilitário para impressão de resultados.
 *
 * Created by Gustavo on 19/11/2015.
 */
public class PrintUtil {

    public static void print(Stream stream){
        System.out.println();
        stream.forEach(s -> System.out.println(s));
    }

    public static void print(Collection list){
        System.out.println();
        list.forEach(s -> System.out.println(s));
    }

    public static void print(Map map){
        System.out.println();
        map.forEach((k, v) -> System.out.println("key="+ k +" | value="+ v ));
    }

    public static void print(String string){
        System.out.println();
        System.out.println(string);
    }

    public static void print(Object string){
        System.out.println();
        System.out.println(string);
    }

}
