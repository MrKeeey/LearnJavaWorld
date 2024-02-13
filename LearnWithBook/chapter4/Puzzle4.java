package LearnWithBook.chapter4;

public class Puzzle4 {
    public static void main(String[] args) {

        int y = 1;
        int x = 0;
        int result = 0;
        Puzzle4b[] obs = new Puzzle4b[6];

        while(x < 6) {
            obs[x] = new Puzzle4b();
            obs[x].ivar = y;
            y = y * 10;
            x++;
        }

        x = 6;
        while (x > 0) {
            x--;
            result = result + obs[x].doStuff(x);
        }
        System.out.println("Result: " + result);
    }
}

class Puzzle4b {
    int ivar;
    public int doStuff(int factor) {

        if (ivar > 100) {
            return ivar * factor;
        } else {
            return ivar * (5 - factor);
        }
    }
}