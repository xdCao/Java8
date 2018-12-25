package ch2;

import ch1.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @Author: buku.ch
 * @Date: 2018-12-25 11:29
 */


public class Example4 {

    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T t : list) {
            c.accept(t);
        }
    }

    public static void main(String[] args) {
        forEach(Arrays.asList(1, 2, 3, 4, 5), (Integer i) -> System.out.println(i));

        List<Integer> list = map(Arrays.asList("asdas", "sdadas", "as"), (String s) -> s.length());


        Comparator<Apple> c = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
        Comparator<Apple> c1 = (a1, a2) -> a1.getWeight().compareTo(a2.getWeight());

    }


    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(f.apply(t));
        }
        return result;
    }


}
