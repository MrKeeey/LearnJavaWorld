package LearnWithBook.chapter8;
abstract public class Animals {

    public void roam() {
        System.out.println("walking");
    }
    public static void main(String[] args) {

    }
}
 abstract class Canine extends Animals {
     public void roam() {
         System.out.println("walking");
     }
 }

 abstract class Feline extends Animals {

 }

class Hippo {

}

class Dog extends Canine {
    public void go() {
        Canine canine;
        canine = new Dog();
        //canine = new Canine();
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


