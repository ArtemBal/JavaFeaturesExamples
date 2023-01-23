package balan.artem.streams.HabrExamples;

import java.util.*;
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
        sample.test5();
        sample.test6();
        sample.test7();
        sample.test8();
        sample.test9();
        sample.test10();
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
                .forEach(System.out::println);
    }

    /**
     * sort by age in reverse
     */
    private void test3() {
        System.out.println("Test 3");

        userList.stream()
                .sorted(Comparator.comparing(User::getAge).reversed())
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
                .forEach(System.out::println);
    }

    /**
     * get average age and max first name length
     */
    private void test5() {
        System.out.println("Test 5");
        double averageAge = userList.stream()
                .mapToInt(User::getAge)
                .summaryStatistics()
                .getAverage();
        System.out.println("Average age: " + averageAge);
        int firstNameLength = userList.stream()
                .mapToInt((value) -> value.getFirstName().length())
                .summaryStatistics()
                .getMax();
        System.out.println("max first name length: " + firstNameLength);
    }

    /**
     * check if all ages less than 79
     */
    private void test6() {
        System.out.println("Test 6");
        boolean isAllAgesLess79 = userList.stream()
                .allMatch((user -> user.getAge() < 79));
        System.out.println("Is all users age less than 79: " + isAllAgesLess79);
    }

    /**
     * check if any first name starts with M char
     */
    private void test7() {
        System.out.println("Test 8");
        boolean isFirstCharS = userList.stream()
                .anyMatch((user -> user.getFirstName().charAt(0) == 'M'));
        System.out.println("Is any first name starts with M: " + isFirstCharS);
    }

    /**
     * transform into another collection
     */
    private void test8() {
        System.out.println("Test 9");
        List<User> list = userList.stream()
                .collect(Collectors.toList());
        Set<User> set = userList.stream()
                .collect(Collectors.toSet());
        List<User> linkedList = userList.stream()
                .collect(Collectors.toCollection(LinkedList::new));
        Map<Long, User> map = userList.stream()
                .collect(Collectors.toMap(user -> user.getId(), user -> user));
    }

    /**
     * count different nationalities
     */
    private void test9() {
        System.out.println("Test 9");
        long countDifNationalities = userList.stream()
                .map(User::getNationality)
                .distinct()
                .count();
        System.out.println("count of different nationalities: " + countDifNationalities);
    }


    /**
     * filter users by few parameters
     */
    private void test10() {
        System.out.println("Test 10");
        userList.stream()
                .filter(p -> (p.getFirstName().charAt(0) != 'M'))
                .filter(p -> (p.getAge() > 10))
                .forEach(System.out::println);

    }
}
