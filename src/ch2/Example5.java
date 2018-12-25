package ch2;

import ch1.Apple;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import ch2.Example2;

/**
 * @Author: buku.ch
 * @Date: 2018-12-25 15:06
 */

/*越来越简洁的写法,对苹果排序*/
public class Example5 {

    public static void main(String[] args) {

        List<Apple> apples = Arrays.asList(new Apple(), new Apple());

        /*传统写法*/
        class AppleComparator implements Comparator<Apple> {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        }
        apples.sort(new AppleComparator());

        /*匿名内部类*/
        apples.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });

        /*Lambda表达式*/
        apples.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));

        /*类型推断*/
        apples.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));

        /*利用Comparing函数*/
        apples.sort(Comparator.comparing((a) -> a.getWeight()));

        /*方法引用*/
        apples.sort(Comparator.comparing(Apple::getWeight));


        apples.sort(Comparator.comparing(Apple::getWeight).reversed());

        apples.sort(Comparator.comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));


        Predicate<Apple> redApple = a -> a.getColor().equals("red");

        Predicate<Apple> notRed = redApple.negate();

        Predicate<Apple> redAndHeavy = redApple.and(a -> a.getWeight() > 150);


    }

}
