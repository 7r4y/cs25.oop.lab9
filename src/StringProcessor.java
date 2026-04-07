import java.util.*;
import java.util.function.*;

public class StringProcessor {

    public static void processStrings(
            List<String> strings,
            Predicate<String> filter,
            Function<String, String> transformer,
            Consumer<String> printer) {

        for (String s : strings) {
            if (filter.test(s)) {           //  Predicate-аар шүүх
                String transformed = transformer.apply(s);  // 2️Function-оор хувиргах
                printer.accept(transformed);                // 3️ Consumer-оор хэвлэх
            }
        }
    }

    public static void main(String[] args) {

        List<String> words = Arrays.asList("Java", "Programming", "Code");

        // 5 тэмдэгтээс урт үгсийг шүүх Predicate
        Predicate<String> longerThan5 = s -> s.length() > 5;

        // Уг үгийг урвуулж хувиргах Function
        Function<String, String> reverse = s -> new StringBuilder(s).reverse().toString();

        // Том үсгээр, "ГАРШИЛ: " prefix-тэй хэвлэх Consumer
        Consumer<String> printer = s -> System.out.println("GARSHIL: " + s.toUpperCase());

        // Process strings
        processStrings(words, longerThan5, reverse, printer);
    }
}