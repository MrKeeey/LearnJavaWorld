package HeadFirst.chapter9;

public class SonOfBoo extends Boo {
    public SonOfBoo(){
        super("boo");
    }

    public SonOfBoo(int i){
        super("Fred");
    }

    public SonOfBoo(String s){
        super(42);
    }
/*
    public SonOfBoo(int i, String s){                   //3 pic

    }

    public SonOfBoo(String a, String b, String c){      //1 pic
        super(a, b);
    }
*/
    public SonOfBoo(int i, int j){
        super("man", j);
    }
/*
    public SonOfBoo(int i, int x, int y){               //2 pic
        super(i, "super");
    }
*/
    public static void main(String[] args) {
        System.out.println("Working!");
    }
}
class Boo {
    public Boo (int i ){}
    public Boo (String s ){}
    public Boo (String s, int i ){}
}