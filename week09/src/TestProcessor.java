import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestProcessor {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Hello", "World", "fQwQf");
        StringPrinter stringPrinter = new StringPrinter();
        System.out.println("Processing Strings:");
        ProcessorUtil.apply(strings, stringPrinter);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        NumberSummer numberSummer = new NumberSummer();
        ProcessorUtil.apply(numbers, numberSummer);
        System.out.println("Sum of Numbers: " + numberSummer.getSum());

        // 拓展内容测试
        List<Object> dest = new ArrayList<>();
        List<Integer> src = Arrays.asList(1,2,3);
        collect(dest, src);
        System.out.println("Collected list: "+dest);

    }

    // 拓展内容
    public static <T> void collect(List<? super T> dest, List<T> src) {
        dest.addAll(src);
    }

}