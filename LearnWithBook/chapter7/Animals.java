package LearnWithBook.chapter7;

public class Animals {
    public static void main(String[] args) {

        Animals[] animals = new Animals[5];

        animals [0] = new Dog();
        animals [1] = new Cat();
        animals [2] = new Wolf();
        animals [3] = new Hippo();
        animals [4] = new Lion();

        for (int count = 0; count < animals.length; count++){
            animals[count].eat();
            animals[count].roam();
        }
    }

    public eat(){

    }

    public roam(){

    }
}
