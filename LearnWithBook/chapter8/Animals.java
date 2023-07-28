package LearnWithBook.chapter8;
abstract public class Animals {

    abstract public void roam();
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.roam();
        Cat cat = new Cat();
        cat.roam();
        dog.go();
    }
}
 abstract class Canine extends Animals {
     public void roam() {
         System.out.println("walking");
     }
 }

 abstract class Feline extends Animals {
     public void roam() {
         System.out.println("running");
     }
 }

class Hippo {
    public void roam() {
        System.out.println("looking");
    }
}

class Dog extends Canine {
    public void go() {
        Canine canine;
        canine = new Dog();
        canine.roam();
    }

}

class Wolf extends Canine {

}

class Cat extends Feline {

}

class Lion extends Feline {

}

class Tiger extends Feline {

}


