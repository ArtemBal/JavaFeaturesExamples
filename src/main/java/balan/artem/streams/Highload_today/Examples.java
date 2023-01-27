package balan.artem.streams.Highload_today;

import java.util.Arrays;
import java.util.List;

public class Examples {

    List<String> myList = Arrays.asList("Highload", "High", "Load", "Highload");

    public static void main(String[] args) {
        Examples examples = new Examples();
        examples.test1();
    }

    private void test1() {
        System.out.println("Test 1");
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

}
