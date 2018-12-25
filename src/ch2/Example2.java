package ch2;

import ch1.Apple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Author: buku.ch
 * @Date: 2018-12-24 20:40
 */


public class Example2 {


    interface Predicate<T> {
        boolean test(T t);
    }


    public static <T> List<T> printList(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();

        for (T t : list) {
            if (p.test(t)) {
                result.add(t);
            }
        }
        return result;
    }


    public static void main(String[] args) {

        Comparator<Apple> comparator = new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight()-o2.getWeight();
            }
        };


        Comparator<Apple> lambdaComparator = (Apple a1,Apple a2) -> a1.getWeight().compareTo(a2.getWeight());

    }


}
