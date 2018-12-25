package ch1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: buku.ch
 * @Date: 2018-12-24 15:16
 */


public class Example1 {

    /*
    * 旧的方式,过滤出绿色苹果
    * */
    public static List<Apple> filterGreenApples(List<Apple> apples) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple:apples) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }


    /*
     * 旧的方式,过滤出重量超过给定值的苹果
     * */
    public static List<Apple> filterHeavyApples(List<Apple> apples) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple:apples) {
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
    }

    /*
     * Java8行为参数化
     * */
    interface Predicate<T> {
        boolean test(T t);
    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight()>150;
    }

    static List<Apple> filterApples(List<Apple> apples,Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple:apples) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    /*调用实例*/
    public static void main(String[] args) {

        List<Apple> apples = Arrays.asList(new Apple());

        filterApples(apples, Example1::isGreenApple);
        filterApples(apples, Example1::isHeavyApple);

    }


}
