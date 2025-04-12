import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


class Animal {
    public void makeSound() {
        System.out.println("Generic animal sound");
    }
}

class Dog extends Animal {
    public void bark() {
        System.out.println("Woof!");
    }

    @Override
    public void makeSound() {
        System.out.println("Dog sound");
    }
}

class Cat extends Animal {
    public void meow() {
        System.out.println("Meow!");
    }

    @Override
    public void makeSound() {
        System.out.println("Cat sound");
    }
}

public class Test {

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Dog());
        animals.add(new Cat());

        processAnimals(animals, animal -> animal.makeSound());

        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());
        dogs.add(new Dog());

        processAnimals(dogs, dog -> dog.makeSound());
    }

    public static void processAnimals(List<? extends Animal> animals, Consumer<? super Animal> consumer) {
        for (Animal animal : animals) {
            consumer.accept(animal);
        }
    }
}
