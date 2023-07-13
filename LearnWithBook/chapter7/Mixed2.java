package LearnWithBook.chapter7;
public class Mixed2 {
    public static void main(String[] args) {
        A a = new A();
        A b = new B();
        A c = new C();
        A a2 = new C();

        b.m1();
        c.m2();
        a.m3();
    }
}
class A {
    int ivar = 7;
    void m1(){
        System.out.println("A's m1, ");
    }
    void m2(){
        System.out.println("A's m2, ");
    }
    void m3(){
        System.out.println("A's m3, ");
    }
}

class B  extends A {
    void m1(){
        System.out.println("B's m1, ");
    }
}

class C  extends B {
    void m3(){
        System.out.println("C's m3, " + (ivar + 6));
    }
}

/*
b.m1();
c.m2();
a.m3();


 */