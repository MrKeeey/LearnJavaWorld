package LearnWithBook.chapter4;

public class Dog {

    int size;
    String name;

    void bark(){
        if (size > 60) {
            System.out.println("Wooof! Wooof!");
        } else if (size > 14){
            System.out.println("Ruff! Ruff!");
        } else {
            System.out.println("Yip! Yip!");
        }
    }

    void bark (int NumOfBarks){
        while (NumOfBarks > 0){
            System.out.println("Gav!");
            NumOfBarks--;
        }
    }

    int giveSecretCode(){
        return 42;
    }
}
class DogTest {
    public static void main(String[] args) {
        Dog one = new Dog();
        Dog two = new Dog();
        Dog three = new Dog();

        one.size = 70;
        two.size = 8;
        three.size = 35;

        one.bark();
        two.bark();
        three.bark();

        one.bark(3);
        int theSecretCode = two.giveSecretCode();
        System.out.println(theSecretCode + " = " + two.giveSecretCode());
    }
}