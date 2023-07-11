package LearnWithBook.chapter7;

public class Animals {
    public static void main(String[] args) {

        Animals[] animals = new Animals[5];

        animals[0] = new Dog();
        animals[1] = new Cat();
        animals[2] = new Wolf();
        animals[3] = new Hippo();
        animals[4] = new Lion();

        for (int count = 0; count < animals.length; count++){
            animals[count].eat();
            animals[count].roam();
        }
    }

    public void eat(){
        System.out.print("Eating");
    }

    public void roam(){
        System.out.println("I'm walking");
    }
}

class Dog extends Animals {
    @Override
    public void eat() {
        super.eat();
        System.out.println(" Dog ");

    }
}
class Cat extends Animals {
    public void eat() {
        super.eat();
        System.out.println(" Cat ");

    }
}
class Wolf extends Animals {
    public void roam(){
        super.roam();
        System.out.println("Wolf");
    }

}
class Hippo extends Animals {
    public void roam(){
        super.roam();
        System.out.println("Hippo");
    }
}
class Lion extends Animals {
    public void roam(){
        super.roam();
        System.out.println("Lion");
    }
    public void eat(){
        super.eat();
        System.out.println("LION");
    }
}

class Vet{
    public void giveShot (Animals a){
        a.roam();
    }
}

class petOwner {
    public void start(){
        Vet v = new Vet();
        Dog d = new Dog();
        Hippo h = new Hippo();

        v.giveShot(d);
        v.giveShot(h);
    }
}