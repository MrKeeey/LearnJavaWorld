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
    }
}