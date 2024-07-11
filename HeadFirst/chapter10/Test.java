package HeadFirst.chapter10;

public class Test {
    Integer i = 0;
    int j;

    public static void main(String[] args) {
        int rnd = (int) Math.round(42.2);
        int min = Math.min(56, 12);
        int abs = Math.abs(-343);
        System.out.println(rnd + " " + min + " " + abs);

        System.out.println(Player.playerCount);
        Player player = new Player("EMEOWII");
        System.out.println(Player.playerCount + " " + player.name);
        System.out.println(player.playerCount + " " + player.name);         //same but worst
        Player.playerCount = 53;
        System.out.println(Player.playerCount);

        System.out.println(Player.TT + " " + Player.SS);
        Player.test();
        player.test();      //same but worst

        Test t = new Test();
        t.go();
    }

    public void go(){
        Integer k = new Integer(5);  //old
        j = i + k;
        System.out.println(j);
        System.out.println(i);

    }
}
class Player{
    static int playerCount;
    static final int TT = 15;
    static final int SS;
    public String name;

    public Player(String n){
        name = n;
        playerCount++;
    }

    static {
        SS = (int) (Math.random() * 15);
    }

    static void test() {
        System.out.println("Static method");
    }
}

