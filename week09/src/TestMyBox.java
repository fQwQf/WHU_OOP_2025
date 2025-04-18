public class TestMyBox {
    public static void main(String[] args) {
        MyBox<String> stringBox = new MyBox<>();
        stringBox.set("Hello, World!");
        System.out.println("String Box: " + stringBox);

        MyBox<Integer> integerBox = new MyBox<>();
        integerBox.set(123);
        System.out.println("Integer Box: " + integerBox);

        MyBox<Double> doubleBox = new MyBox<>();
        doubleBox.set(3.14);
        System.out.println("Double Box: " + doubleBox);

        MyBox<String> anotherStringBox = new MyBox<>();
        anotherStringBox.set("Hello, World!");

        System.out.println("String Box equals anotherStringBox: " + stringBox.equals(anotherStringBox));
        System.out.println("String Box equals integerBox: " + stringBox.equals(integerBox));
    }
}