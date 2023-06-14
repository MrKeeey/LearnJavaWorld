package LearnWithBook.chapter3;

class Dog{
    void bark(){
        System.out.println("Woof Woof");
    }
}

class Cat{
    void meow(){
        System.out.println("Meooooow");
    }
}
public class DogCat {
    public static void main(String[] args) {
        Dog dog = new Dog();
        //dog = null;
        Cat cat = new Cat();

        dog.bark();
        cat.meow();
    }
}
