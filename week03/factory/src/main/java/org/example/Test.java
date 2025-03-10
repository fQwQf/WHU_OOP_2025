package org.example;

public class Test {
    public static void main(String[] args) {
        // 使用 Circle 工厂
        ShapeFactory circleFactory = new CircleFactory();
        Shape circle = circleFactory.createShape();
        circle.draw();

        // 使用 Rectangle 工厂
        ShapeFactory rectangleFactory = new RectangleFactory();
        Shape rectangle = rectangleFactory.createShape();
        rectangle.draw();
    }
}