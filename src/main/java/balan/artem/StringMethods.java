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

    public static void methodsStrip() {
        String originalString1 = " prepared string surrounded by spaces ";
        methodRepeat("String.strip() on '" + originalString1 + "'");
        out.println("'" + originalString1.strip() + "'");

        String originalString2 = " prepared string surrounded by spaces ";
        methodRepeat("String.stripLeading() on '" + originalString2 + "'");
        out.println("'" + originalString2.stripLeading() + "'");

        String originalString = " prepared string surrounded by spaces ";
        methodRepeat("String.stripTrailing() on '" + originalString + "'");
        out.println("'" + originalString.stripTrailing() + "'");
    }

    public static void methodIsBlank() {
        methodRepeat("String.isBlank()");
        String emptyString = "";
        out.println("Empty String -> " + emptyString.isBlank());
        String onlyLineSeparator = System.getProperty("line.separator");
        out.println("Line Separator Only -> " + onlyLineSeparator.isBlank());
        String tabOnly = "\t";
        out.println("Tab Only -> " + tabOnly.isBlank());
        String spacesOnly = "   ";
        out.println("Spaces Only -> " + spacesOnly.isBlank());
        String spacesAndSymbols = " S R ";
        out.println("Spaces and symbols -> " + spacesAndSymbols.isBlank());
    }

    public static void main(String[] args) {
        methodRepeat("AB");
        methodLines();
        methodsStrip();
        methodIsBlank();
    }
}
