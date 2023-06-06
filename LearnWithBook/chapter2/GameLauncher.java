public class GameLauncher {
    public static void main(String[] args) {
        GuessGame game = new GuessGame();
        game.startGame();
    }
}

public class Player {
    int number = 0;
    public void guess(){
        number = (int) (Math.random() * 10);
        System.out.println("I think, it's number: " + number);
    }
}

public class GuessGame {
    Player p1;
    Player p2;
    Player p3;

    public void startGame(){
        p1 = new Player();
        p2 = new Player();
        p3 = new Player();

        int guessp1 = 0;
        int guessp2 = 0;
        int guessp3 = 0;

        boolean p1isRight = false;
        boolean p1isRight = false;
        boolean p1isRight = false;
    }
}
