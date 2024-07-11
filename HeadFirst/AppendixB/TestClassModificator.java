package HeadFirst.AppendixB;

public class TestClassModificator {
    public static void main(String[] args) {
        new B();
        TestClassModificator test = new TestClassModificator();
        test.cTest();
    }

    public void aTest() {
        System.out.println("A");
    }
    void bTest() {
        System.out.println("B");
    }
    private void cTest() {
        System.out.println("C");
    }
    protected void dTest() {
        System.out.println("D");
    }
}

class B extends TestClassModificator {
    B() {
        aTest();
        bTest();
        dTest();
    }
}