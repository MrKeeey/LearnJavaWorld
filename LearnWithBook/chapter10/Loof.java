package LearnWithBook.chapter10;

public class Loof {
    public static void main(String[] args) {
        Foof foo = new Foof();
        System.out.println(foo.day + "." + foo.mounth + "." + foo.doMore());
    }
}

class Foof {
    final int day = 8;
    final int mounth;

    Foof() {
        mounth = 15;
    }

    void doStuff(final int c){
        int count = c;
    }

    int doMore(){
        final int year = 1992;
        return year;
    }
}

class Poof {
    final void MagicPoof() {
        String MagicMsg = "Magic just magic";
    }

    final String GreatMagicPoof() {
        return "That was Great Magic";
    }
}

final class Woof {
    String Msg = "This is WooF";
}