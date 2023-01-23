package balan.artem.streams.JavaRush;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Examples {
    List<String> myList = new ArrayList<>();

    public Examples() {
        myList.add("One");
        myList.add("Two");
        myList.add("Three");
        myList.add("Four");
        myList.add("Five");
        myList.add("Six");
        myList.add("Seven");
        myList.add("Eight");
        myList.add("Nine");
        myList.add("Ten");
    }

    public static void main(String[] args) {
        Examples examples = new Examples();
        examples.test1();
        examples.test2();
        examples.test3();
        examples.test4();
    }

    private void test1() {
        System.out.println("Test 1");
        myList.stream()
                .filter(p -> p.length() == 3)
                .forEach(System.out::println);
    }

    private void test2() {
        System.out.println("Test 2");
        myList.stream()
                .filter(p -> p.length() == 3)
                .map(p -> p + " - the length of the letters is three")
                .forEach(System.out::println);
    }

    private void test3() {
        System.out.println("Test 3");
        String[] array = {"Java", "Ruuuuussshhh"};
        Stream<String> streamOfArray = Arrays.stream(array);
        streamOfArray.map(s->s.split(""))
                .flatMap(Arrays::stream).distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    private void test4() {
        System.out.println("Test 4");
        String[] array = {"Java", "Ruuuuussshhh"};
        Stream<String> streamOfArray = Arrays.stream(array);
        streamOfArray.map(s->s.split(""))
                .map(Arrays::stream).distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

}
