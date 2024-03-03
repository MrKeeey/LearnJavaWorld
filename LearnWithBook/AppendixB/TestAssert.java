package LearnWithBook.AppendixB;

public class TestAssert {
    public static void main(String[] args) {
        int height = 10, weight = 5;                                    //javac LearnWithBook/AppendixB/TestAssert.java
        assert (height < 5) : "Height: " + height;                      //java -ea LearnWithBook.AppendixB.TestAssert
        if (height > 5) {
            System.out.println("Height so big: " + --height);
        } else
            System.out.println("Your height: " + height);
    }
}
