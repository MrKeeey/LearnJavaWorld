package LearnWithBook.chapter7;

public class TestBoats {
    public static void main(String[] args) {
        Boat b1 = new Boat();
        Sailboat b2 = new Sailboat();
        Rowboat b3 = new Rowboat();


    }
}

class Boat {
    private int length;
    public void setLength (int len) {
        length = len;
    }

    public int getLength() {
        return length;
    }

    public void move() {
        System.out.println("drift");
    }
}
class Rowboat extends Boat {

}

class Sailboat extends Boat {

}