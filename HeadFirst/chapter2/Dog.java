package HeadFirst.chapter2;

public class Dog {
    int size;
    String breed, name;

    void TaskBottle() {
        int counter = 0, bottle5 = 5;
        double bottle55 = 5.55, costbottle5 = 2.1, costbottle55 = 2.68;

        while (counter < 11) {
            System.out.println(bottle5 + " = " + String.format("%.2f", costbottle5) + " | " + bottle55 + " = " + String.format("%.2f", costbottle55));
            bottle5 = bottle5 + 5;
            costbottle5 = costbottle5 + 2.1;
            bottle55 = bottle55 + 5.5;
            costbottle55 = costbottle55 + 2.68;
            counter++;
        }
    }
    void bark(){
        System.out.println("Woof woof!");
    }
}

class DogTest {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.size = 40;
        d.bark();
        //a bootle with 5l or 5.55l
        d.TaskBottle();
    }
}
