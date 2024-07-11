package HeadFirst.AppendixB;

public class TestModClass {
    public static void main(String[] args) {
        TestClassModificator test = new TestClassModificator();
        test.aTest();
        test.bTest();
        new Prot();
    }
}
class Prot extends TestClassModificator{
    Prot() {
        dTest();
    }
}
