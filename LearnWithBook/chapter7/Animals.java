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
        System.out.print("eating ");
    }

    public void roam(){
        System.out.println("walking");
    }
}

class Dog extends Animals {
    @Override
    public void eat() {
        System.out.print("Dog ");
        super.eat();
    }
}
class Cat extends Animals {
    public void eat() {
        System.out.print("Cat ");
        super.eat();
    }
}
class Wolf extends Animals {
    public void eat(){
        //super.eat();
    }
    public void roam(){
        System.out.print("Wolf ");
        super.roam();
    }

}
class Hippo extends Animals {
    public void eat(){
        //super.eat();
    }
    public void roam(){
        System.out.print("Hippo ");
        super.roam();
    }
}
class Lion extends Animals {
    public void roam(){
        //System.out.print("LION ");
        //super.roam();
    }
    public void eat(){
        System.out.print("Lion ");
        super.eat();
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

        //v.giveShot(d);
        //v.giveShot(h);
    }
}