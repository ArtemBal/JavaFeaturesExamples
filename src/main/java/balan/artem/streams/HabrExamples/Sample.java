package balan.artem.streams.HabrExamples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sample {

    private final List<User> userList = Arrays.asList(
            new User(1, "Michael", "Robert", 37, "TR"),
            new User(2, "Mary", "Patricia", 11, "EN"),
            new User(3, "John", "Michael", 7, "FR"),
            new User(4, "Jennifer", "Linda", 77, "TR"),
            new User(5, "William", "Elizabeth", 23, "US"),
            new User(6, "Sue", "Jackson", 11, "IT"),
            new User(7, "Michael", "Tommy", 37, "EN")
    );

    public static void main(String... args) {
        Sample sample = new Sample();
        sample.test1();
        sample.test2();
        sample.test3();
        sample.test4();
    }

    /**
     * print all elements with forEach
     */
    private void test1() {
        System.out.println("Test 1");

        userList.stream().
                forEach(System.out::println);
    }

    /**
     * take every element and change them somehow before print
     */
    private void test2() {
        System.out.println("Test 2");

        userList.stream()
                .map(u -> new User(
                        u.getId() + 1,
                        "F " + u.getFirstName(),
                        "L " + u.getLastName(),
                        u.getAge() + 5,
                        u.getNationality() + " bumpkin")
                )
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    /**
     * sort by age in reverse
     */
    private void test3() {
        System.out.println("Test 3");

        userList.stream()
                .sorted(Comparator.comparing(User::getAge).reversed())
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    /**
     * sort by multiple fields (one in reverse)
     */
    private void test4() {
        System.out.println("Test 4");

        userList.stream()
                .sorted(Comparator.comparing(User::getAge)
                        .thenComparing(Comparator.comparing(User::getFirstName).reversed())
                        .thenComparing(User::getLastName))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
