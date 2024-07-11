package HeadFirst.chapter10;

public class FooTest {
    public static void main(String[] args) {
        Foo foo = new Foo();
        Foo2 foo2 = new Foo2();
        Foo3 foo3 = new Foo3();
        Foo4 foo4 = new Foo4();
        Foo5 foo5 = new Foo5();
        Foo6 foo6 = new Foo6();
    }
}

class Foo {
    static int x;

    public Foo(){
        System.out.println("Foo");
    }
    public void go(){
        System.out.println(x);
    }
}

class Foo2 {
    int x;

    public Foo2(){
        System.out.println("Foo2");
    }
    public void go(){
        System.out.println(x);
    }
}

class Foo3 {
    final int x;

    public Foo3(){
        x = 1;
        System.out.println("Foo3");
    }
    public void go(){
        System.out.println(x);
    }
}

class Foo4 {
    static final int x = 12;

    public Foo4(){
        System.out.println("Foo4");
    }
    public void go(){
        System.out.println(x);
    }
}

class Foo5 {
    static final int x = 12;

    public Foo5(){
        System.out.println("Foo5");
    }
    public void go(final int x){
        System.out.println(x);
    }
}

class Foo6 {
    int x = 12;

    public Foo6(){
        System.out.println("Foo6");
    }
    public void go(final int x){
        System.out.println(x);
    }
}