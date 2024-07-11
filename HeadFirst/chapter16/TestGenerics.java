package HeadFirst.chapter16;

import java.util.ArrayList;

public class TestGenerics {
    public static void main(String[] args) {
        new TestGenerics().go();
        Dog.bark();
    }

    //method for array Animal[]
    /*public void go() {
        Animal[] animals = {new Dog(), new Cat(), new Dog()};
        Dog[] dogs = {new Dog(), new Dog(), new Dog()};
        takeAnimals(animals);
        takeAnimals(dogs);
    }*/

    public void go() {
        ArrayList <Animal> animals = new ArrayList<Animal>();
        animals.add(new Dog());
        animals.add(new Cat());
        animals.add(new Cat());
        takeAnimals(animals);

        ArrayList <Dog> dogs = new ArrayList<Dog>();
        dogs.add(new Dog());
        dogs.add(new Dog());
        takeAnimals(dogs);
    }

    //public void takeAnimals(Animal[] animals) {
    //public void takeAnimals(ArrayList<? extends Animal> animals) {
    public <T extends Animal> void takeAnimals(ArrayList<T> animals) {              //same but for more arguments + you cannot use animals.add()
        for (Animal a: animals) {
            a.eat();
        }
    }
}

abstract class Animal {
    void eat() {
        System.out.println("I'm eating!");
    }
}

class Dog extends Animal {
    void eat() {
        System.out.println("Woof is eating!");
    }

    static void bark() {
        System.out.println("Woof woof!");
    }
}

class Cat extends Animal {
    void meow() {
        System.out.println("Meeeeeeeeeeeeeow");
    }
}