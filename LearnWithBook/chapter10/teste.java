package LearnWithBook.chapter10;

public class teste {
    public static void main(String[] args) {
        tt TT = new tt();
        System.out.println(TT.name);
        System.out.println(tt.names);
    }
}

class tt {
    final String name = "Meow";
    static String names = "So much meow";
    tt(){
       System.out.println("TT");
    }

}