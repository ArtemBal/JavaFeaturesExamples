package balan.artem.swithExpressions;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Example {

    /**
     * Old version of switch
     */
    private void test1() {
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
                switch (dayOfWeek) {
                    case SUNDAY:
                    case SATURDAY:
                        System.out.println("Weekend");
                        break;
                    case FRIDAY:
                    case THURSDAY:
                    case WEDNESDAY:
                    case TUESDAY:
                    case MONDAY:
                        System.out.println("Weekday");
                        break;
                    default:
                        System.out.println("Unknown Day!");
                }
    }

    private void test2(){
        DayOfWeek day = LocalDate.now().getDayOfWeek();
        System.out.println(switch (day) {
            case SUNDAY, SATURDAY -> "Weekend";
            case FRIDAY, THURSDAY, WEDNESDAY, TUESDAY, MONDAY -> "Weekday";
        });
    }

    private String test3(Object o) {
        return switch (o) {
            case Integer i -> String.format("int %d", i);
            case Long l    -> String.format("long %d", l);
            case Double d  -> String.format("double %f", d);
            case String s  -> String.format("String %s", s);
            default        -> o.toString();
        };
    }

    public static void main(String[] args) {
        Example example = new Example();
        example.test1();
        example.test2();
        System.out.println(example.test3(5d));
    }
}
