package LearnWithBook.chapter10;

public class Test {
    public static void main(String[] args) {
        int rnd = (int) Math.round(42.2);
        int min = Math.min(56, 12);
        int abs = Math.abs(-343);
        System.out.println(rnd + " " + min + " " + abs);

        System.out.println(Player.playerCount);
        Player player = new Player("SEMMII");
        System.out.println(Player.playerCount + " " + player.name);
        System.out.println(player.playerCount + " " + player.name);         //same but worst
        Player.playerCount = 53;
        System.out.println(Player.playerCount);

        System.out.println(Player.TT + " " + Player.SS);
        Player.test();
        player.meow();      //same but worst
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

    static void meow() {
        System.out.println("Meow");
    }
}

