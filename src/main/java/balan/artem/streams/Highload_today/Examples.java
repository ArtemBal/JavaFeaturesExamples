package balan.artem.streams.Highload_today;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Examples {



    public static void main(String[] args) {
        Examples examples = new Examples();
        examples.test1();
        examples.test2();
    }

    private void test1() {
        System.out.println("Test 1");
        List<String> myList = Arrays.asList("Highload", "High", "Load", "Highload");

        myList.stream().map(s -> s + " ").forEach(System.out::print);
        System.out.println("\nHigh occurs " + myList.stream().filter("High"::equals).count() + " times");
        System.out.println("First element of collection: " + myList.stream().findFirst().orElse("\"Empty collection\""));
        System.out.println("Use findFirst to get " + myList.stream().filter("Load"::equals).findFirst().orElse("\"Empty collection\"") + " element");
        System.out.println("Use Skip to get last element: " +
                myList.stream().skip(myList.size() - 1).findFirst().orElse("\"Empty collection\""));
        System.out.println("Use Skip to get second element of collection: " +
                myList.stream().skip(1).findFirst().orElse("\"Empty collection\""));
        System.out.println("Use Skip and Limit to get middle part of collection: " +
                Arrays.toString(myList.stream().skip(1).limit(2).toArray()));
    }

    private void test2() {
        System.out.println("Test 2");
        List<String> myList = Arrays.asList("f10", "f15", "f2", "f4");
        System.out.println("Minimal element: " +
                myList.stream().min(String::compareTo).get());
        System.out.println("Max element: " +
                myList.stream().max(String::compareTo).get());

        List<String> duplicateList = Arrays.asList("f10", "f15", "f2", "f4", "f4");
        System.out.println("Sort and to array methods: " +
                duplicateList.stream()
                        .sorted()
                        .collect(Collectors.toList()));
        System.out.println("Sort reverse and delete duplicates: " +
                duplicateList.stream()
                        .sorted((o1, o2) -> - o1.compareTo(o2)).distinct()
                        .collect(Collectors.toList()));
    }

}
