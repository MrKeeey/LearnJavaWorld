package LearnWithBook.chapter10;

public class AllFinalTest {
    public static void main(String[] args) {
        BDay bDay = new BDay();
        System.out.println(bDay.day + "." + bDay.mounth + "." + bDay.Years());
        bDay.doStuff(9);

        Poof poof = new Poof();
        poof.MagicPoof();
        System.out.println(poof.GreatMagicPoof());

        Woof woof = new Woof();
    }
}

class BDay {
    final int day = 8;
    final int mounth;

    BDay() {
        mounth = 15;
    }
    void doStuff(final int c){
        int count = c;
        System.out.println("Working " + count + " years");
    }

    int Years(){
        final int year = 1992;
        return year;
    }
}

class Poof {
    final void MagicPoof() {
        System.out.println("Magic just magic");
    }
    final String GreatMagicPoof() {
        return "That was Great Magic";
    }
}

final class Woof {
    Woof(){
        System.out.println("This is WooF");
    }
}