package LearnWithBook.chapter9;
import java.util.ArrayList;

class Animals {
    public String infoA = "Animals";
    Animals(ArrayList list){
        for (int count = 0; count < 5; count++){
            list.add(new SimUnit(infoA));
        }
    }
    /*@Override
    public String toString(){
        return infoA + " ";
    }*/
}

public class Test {
    public static void main(String[] args) {
        ArrayList aList = new ArrayList();
        System.out.println(aList);
        Animals a = new Animals(aList);
        for (Object al : aList) {
            System.out.print(al + " ");
        }
    }
}

class SimUnit {
    String botType;

    SimUnit(String type) {
        botType = type;
    }
}