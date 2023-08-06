package LearnWithBook.chapter9;

public class GC {
    public static GC doStuff(){
        GC newGC = new GC();
        doStuff2(newGC);
        return newGC;
    }
    public static void main(String[] args) {

    }

    public static void doStuff2(GC copyGC){
        GC localGC;
    }
}
