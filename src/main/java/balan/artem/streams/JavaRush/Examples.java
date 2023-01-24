package balan.artem.streams.JavaRush;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
        examples.test5();
        examples.test6();
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

    /**
     * transform into one stream of strings
     */
    private void test3() {
        System.out.println("Test 3");
        String[] array = {"Java", "Ruuuuussshhh"};
        Stream<String> streamOfArray = Arrays.stream(array);
        streamOfArray.map(s -> s.split(""))
                .flatMap(Arrays::stream).distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    /**
     * transform into stream of streams of strings
     */
    private void test4() {
        System.out.println("Test 4");
        String[] array = {"Java", "Ruuuuussshhh"};
        Stream<String> streamOfArray = Arrays.stream(array);
        streamOfArray.map(s -> s.split(""))
                .map(Arrays::stream).distinct()
                //.flatMap(Stream::distinct)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    /**
     * some intermediate operators tests
     */
    private void test5() {
        System.out.println("Test 5");
        System.out.println("--Stream of streams--");
        Stream.of(2, 3, 0, 1, 3)
                .map(x -> IntStream.range(0, x))
                .forEach(System.out::print);

        System.out.println("\n--Stream of int's--");
        Stream.of(2, 3, 0, 1, 3)
                .flatMapToInt(x -> IntStream.range(0, x))
                .forEach(System.out::print);

        System.out.println("\n--Limit 6 and skip 2--");
        Stream.of(2, 3, 0, 1, 3)
                .flatMapToInt(x -> IntStream.range(0, x))
                .limit(6)
                .skip(2)
                .forEach(System.out::print);

        System.out.println("\n--Skip 2 and limit 6--");
        Stream.of(2, 3, 0, 1, 3)
                .flatMapToInt(x -> IntStream.range(0, x))
                .skip(2)
                .limit(6)
                .forEach(System.out::print);

        System.out.println("\n--Sorted--");
        Stream.of(2, 3, 0, 1, 3)
                .flatMapToInt(x -> IntStream.range(0, x))
                .sorted()
                .forEach(System.out::print);

        System.out.println("\n--Sorted reverse--");
        Stream.of(2, 3, 0, 1, 3)
                .flatMapToInt(x -> IntStream.range(0, x)).boxed()
                .sorted(Collections.reverseOrder())
                .forEach(System.out::print);

        System.out.println("\n--Take while < 2--");
        Stream.of(2, 3, 0, 1, 3)
                .flatMapToInt(x -> IntStream.range(0, x))
                .takeWhile(n -> n < 2)
                .forEach(System.out::print);

        System.out.println("\n--Drop while < 2--");
        Stream.of(2, 3, 0, 1, 3)
                .flatMapToInt(x -> IntStream.range(0, x))
                .dropWhile(n -> n < 2)
                .forEach(System.out::print);

        System.out.println("\n--Iterate--");
        IntStream.iterate(0, n -> n < 20, n -> n + 1)
                .mapToObj(n -> n + " ")
                .forEach(System.out::print);
        System.out.println();
    }


    private void test6() {
        System.out.println("Test 6");
        int sum1 = Stream.of(1, 2, 3, 4, 5).reduce(10, Integer::sum);
        System.out.println("Sum of stream elements + 10: " + sum1);

        Optional<Integer> sum2 = Stream.of(1, 2, 3, 4, 5).reduce(Integer::sum);
        System.out.println("Sum of stream elements: " + sum2.get());

        int min = Stream.of(1, 2, 3, 4, 5).min(Integer::compare).get();
        System.out.println("Min element is: " + min);

        System.out.println("First element is: " + Stream.of(1, 2, 3, 4, 5).findFirst());

        System.out.println("-------------");
        Stream.of(1, 2, 3, 4, 9).forEach(System.out::print);
        System.out.println("\nAll elements are < 3? " + Stream.of(1, 2, 3, 4, 9).allMatch(n -> n < 3));
        System.out.println("Any element is > 4? " + Stream.of(1, 2, 3, 4, 9).anyMatch(n -> n > 4));
        System.out.println("NoneMatch x >= 7 " + Stream.of(1, 2, 3, 4, 9).noneMatch(x -> x >= 7));
    }

}
