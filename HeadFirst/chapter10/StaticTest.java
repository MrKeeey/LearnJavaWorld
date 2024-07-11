package HeadFirst.chapter10;

public class StaticTest extends StaticSuper {

    static int rand;
    final int num;

    static {
        rand = (int)(Math.random() * 8);
        System.out.println("Static block " + rand);
    }

    StaticTest() {
        num = 8;
        System.out.println(num);
        System.out.println("Constructor");
    }
    public static void main(String[] args) {
        System.out.println("Inside Main");
        StaticTest st = new StaticTest();
    }
}

class StaticSuper {
    static{
        System.out.println("Super static block");
    }

    StaticSuper() {
        System.out.println("Super constructor");
    }
}
