package LearnWithBook.chapter10;

import LearnWithBook.chapter4.Sum;

public class teste {
    public static void main(String[] args) {
        tt TT = new tt();
        System.out.println(TT.name);
        System.out.println(tt.names);
        System.out.println(tt.count + TT.count);
        new tt("Felix");
        new tt(tt.count);
    }
}

class tt {
    final String name = "Meow";
    static String names = "So much meow";
    final static int count = 9;
    public tt(){
       System.out.println("TT");
    }

    public tt(String PetName){
        System.out.println(PetName);
    }

    public tt(int x){
        System.out.println(x+1);
    }
}