package balan.artem.streams.Highload_today;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Examples {



    public static void main(String[] args) {
        Examples examples = new Examples();
        examples.test1();
        examples.test2();
        examples.test3();
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

    Collection<Student> students = Arrays.asList(
            new Student("Дмитрий", 17, Gender.MAN),
            new Student("Максим", 20, Gender.MAN),
            new Student("Екатерина", 20, Gender.WOMAN),
            new Student("Михаил", 28, Gender.MAN)
    );
    private enum Gender {
        MAN,
        WOMAN
    }
    private static class Student {
        private final String name;
        private final Integer age;
        private final Gender gender;
        public Student(String name, Integer age, Gender gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }
        public String getName() {
            return name;
        }
        public Integer getAge() {
            return age;
        }
        public Gender getGender() {
            return gender;
        }
        @Override
        public String toString() {
            return "{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender=" + gender +
                    '}';
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof  Student)) return false;
            Student student = (Student) o;
            return Objects.equals(name, student.name) &&
                    Objects.equals(age, student.age) &&
                    Objects.equals(gender, student.gender);
        }
        @Override
        public int hashCode() {
            return Objects.hash(name, age, gender);
        }
    }

    private void test3() {
        System.out.println("Test 3");
        OptionalDouble optionalN = students.stream()
                .filter(s -> s.getGender() == Gender.MAN)
                .mapToInt(Student::getAge)
                .average();
        if(optionalN.isPresent()){
            System.out.println("Average age of mans : " + optionalN.getAsDouble());
        }

        System.out.println("Who will receive a summons to the military: " +
                students.stream()
                        .filter(s -> s.getAge() >= 18 && s.getAge() <= 27 && s.getGender() == Gender.MAN)
                        .collect(Collectors.toList()));

    }

    private void test4() {
        Scanner scanner = new Scanner(System.in);
        String s;
        ArrayList<String> ALL = new ArrayList<>();
        System.out.println("Введите имя: ");
        while (true) {
            System.out.print("имя = ");
            s = scanner.nextLine();
            if (s.equals(""))
                break;
            ALL.add(s);
        }
        System.out.println();
        System.out.println("ALL = " + ALL); // Выводим массив введенных имен
        Predicate<String> fn;
        fn = (str) -> str.charAt(0) == 'A'; // Определяем, что нам нужны имена, начинающиеся на 'A'
        Stream<String> stream = ALL.stream(); // Конвертация массива в поток строк
        Stream<String> resStream = stream.filter(fn); // Получаем список, отфильтрованный по предикату
        System.out.println("count = " + resStream.count()); // Выводим количество имен
    }
}
