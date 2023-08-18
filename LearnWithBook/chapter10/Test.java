package LearnWithBook.chapter10;

public class Test {
    public static void main(String[] args) {
        int rnd = (int) Math.round(42.2);
        int min = Math.min(56, 12);
        int abs = Math.abs(-343);
        System.out.println(rnd + " " + min + " " + abs);

        System.out.println(Player.playerCount);
        Player player = new Player("SEMMII");
        System.out.println(Player.playerCount);
        player.playerCount = 53;
        System.out.println(Player.playerCount);
        System.out.println(Player.TT + " " + Player.SS);
    }
}
class Player{
    static int playerCount;
    public static final int TT = 15;
    public static final int SS;
    private String name;
    public Player(String n){
        name =n;
        playerCount++;
    }
    static {
        SS = (int) Math.random() * 15 + 1;
    }
}

