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

    public static void main(String[] args) {
        Example example = new Example();
        example.test1();
    }
}
