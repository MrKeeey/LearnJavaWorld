package LearnWithBook.chapter9;

import java.util.ArrayList;

class Animals {
    Animals(ArrayList list){
        for (int count = 0; count < 5; count++){
            list.add(new SimUnit("Animals"));
        }
    }
}

class Cat {
    Cat(ArrayList list){
        for (int count = 0; count < 5; count++){
            list.add(new SimUnit("Meow"));
        }
    }
}

public class Test {
    public static void main(String[] args) {
        ArrayList aList = new ArrayList();
        Animals animal = new Animals(aList);
        Cat cat = new Cat(aList);
        System.out.println(aList);
    }
}

class SimUnit {
    String botType;
    SimUnit(String type) {
        botType = type;
    }
    public String toString(){
        return botType;
    }
}