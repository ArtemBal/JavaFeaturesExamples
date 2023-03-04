package balan.artem;

import java.util.stream.Stream;

import static java.lang.System.out;

public class StringMethods {

    private static void methodRepeat(String headerText)
    {
        String headerSeparator = "=".repeat(headerText.length()+4);
        out.println("\n" + headerSeparator);
        out.println("= " + headerText + " =");
        out.println(headerSeparator);
    }

    public static void methodLines()
    {
        String originalString = "String with\nline\nterminators";
        String stringWithoutLineSeparators
                = originalString.replaceAll("\\n", "\\\\n");
        methodRepeat("String.lines() on '"  + stringWithoutLineSeparators  + "'");
        Stream<String> strings = originalString.lines();
        strings.forEach(out::println);
    }

    public static void main(String[] args) {
        methodRepeat("AB");
        methodLines();
    }
}
