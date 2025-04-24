## 任务一：实现一个泛型容器类 `MyBox<T>`
MyBox.java
```java
public class MyBox<T> {
    private T item;

    public void set(T item) {
        this.item = item;
    }

    public T get() {
        return item;
    }

    @Override
    public String toString() {
        return "MyBox{" +
                "item=" + item +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyBox<?> other = (MyBox<?>) o;
        if (item == null) {
            return other.item == null;
        }
        return item.equals(other.item);
    }
}
```

TestMyBox.java
```java
public class TestMyBox {
    public static void main(String[] args) {
        MyBox<String> stringBox = new MyBox<>();
        stringBox.set("Hello, World!");
        System.out.println(stringBox.toString());

        MyBox<Integer> integerBox = new MyBox<>();
        integerBox.set(123);
        System.out.println(integerBox.toString());

        MyBox<Double> doubleBox = new MyBox<>();
        doubleBox.set(3.14);
        System.out.println(doubleBox.toString());

        MyBox<String> anotherStringBox = new MyBox<>();
        anotherStringBox.set("Hello, World!");

        System.out.println("String Box equals anotherStringBox: " + stringBox.equals(anotherStringBox));
        System.out.println("String Box equals integerBox: " + stringBox.equals(integerBox));
        System.out.println("String Box equals doubleBox: " + stringBox.equals(doubleBox));
    }
}
```

TestMyBox运行结果：
```shell
/home/fqwqf/.jdks/openjdk-24/bin/java -javaagent:/home/fqwqf/桌面/idea-IC-243.25659.59/lib/idea_rt.jar=33417 -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /home/fqwqf/桌面/project/WHU_OOP_2025/week09/out/production/week09 TestMyBox
MyBox{item=Hello, World!}
MyBox{item=123}
MyBox{item=3.14}
String Box equals anotherStringBox: true
String Box equals integerBox: false
String Box equals doubleBox: false

进程已结束，退出代码为 0
```

## 任务二：设计一个使用泛型接口和方法的集合处理器

Processor.java
```java
public interface Processor<T> {
    void process(T item);
}
```

StringPrinter.java
```java
public class StringPrinter implements Processor<String> {
    @Override
    public void process(String item) {
        System.out.println("Printing: " + item);
    }
}
```

NumberSummer.java
```java
public class NumberSummer implements Processor<Integer> {
    private int sum = 0;

    @Override
    public void process(Integer item) {
        sum += item;
    }

    public int getSum() {
        return sum;
    }
}
```

ProcessorUtil.java
```java
import java.util.List;

public class ProcessorUtil {
    public static <T> void apply(List<? extends T> list, Processor<T> processor) {
        for (T item : list) {
            processor.process(item);
        }
    }
}
```

TestProcessor.java
```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestProcessor {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Java", "Generics", "Example");
        StringPrinter stringPrinter = new StringPrinter();
        System.out.println("Processing Strings:");
        ProcessorUtil.apply(strings, stringPrinter);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        NumberSummer numberSummer = new NumberSummer();
        ProcessorUtil.apply(numbers, numberSummer);
        System.out.println("Sum of Numbers: " + numberSummer.getSum());

        // 拓展内容测试
        List<Number> numberList = Arrays.asList(1, 2.0, 3, 4.5);
        List<Object> objectList = Arrays.asList("a", 1, 2.0, true);
        ProcessorUtil.apply(numberList, item -> System.out.println(item));

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
```


TestProcessor运行结果：
```shell
/home/fqwqf/.jdks/openjdk-24/bin/java -javaagent:/home/fqwqf/桌面/idea-IC-243.25659.59/lib/idea_rt.jar=36553 -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /home/fqwqf/桌面/project/WHU_OOP_2025/week09/out/production/week09 TestProcessor
Processing Strings:
Printing: Hello
Printing: World
Printing: fQwQf
Sum of Numbers: 15
Collected list: [1, 2, 3]

进程已结束，退出代码为 0
```