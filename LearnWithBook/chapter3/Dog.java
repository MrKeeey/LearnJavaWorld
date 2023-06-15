package LearnWithBook.chapter3;

public class Dog {
    String name;
    public static void main(String[] args) {
        Dog dog = new Dog();
        //dog = null;
        dog.bark();
        dog.name = "Bart";

        Dog[] myDog = new Dog[3];
        myDog[0] = new Dog();
        myDog[1] = new Dog();
        myDog[2] = dog;

        myDog[0].name = "Fred";
        myDog[1].name = "Marge";
        System.out.println("Last dog name: " + myDog[2].name);

        int count = 0;
        while (count < myDog.length){
            myDog[count].bark();
            count++;
        }

        myDog[2].chaseCat();
        myDog[1].eat();
        dog.bark();
    }
    void bark() {
        System.out.println(name + " Woof Woof");
    }

    void eat() {
        System.out.println(name + " Omn omn omn woof");
    }

    void chaseCat() {
        System.out.println(name + " Wooooooofffff");
    }
}