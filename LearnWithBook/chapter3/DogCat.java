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
        Dog d = new Dog();
        d = null;
        //Cat d = new Cat();

        d.bark();
        //d.meow();
    }
}
