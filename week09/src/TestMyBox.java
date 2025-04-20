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