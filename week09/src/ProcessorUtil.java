import java.util.List;

public class ProcessorUtil {
    public static <T> void apply(List<? extends T> list, Processor<T> processor) {
        for (T item : list) {
            processor.process(item);
        }
    }
}