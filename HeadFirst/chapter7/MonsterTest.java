package HeadFirst.chapter7;

public class MonsterTest {
    public static void main(String[] args) {
        Monster[] monstr = new Monster[3];
        monstr[0] = new Vampire();
        monstr[1] = new Dragon();
        monstr[2] = new Monster();

        for (int count = 0; count < 3; count++) {
            monstr[count].frighten(count);
        }
    }
}

class Monster {
    boolean frighten(int d) {
        System.out.println("arrrgh");
        return true;
    }
}

class Vampire extends Monster {
    boolean frighten(int b) {
        System.out.println("a bite?");
        return false;
    }
}

class Dragon extends Monster {
    boolean frighten(int degree) {
        System.out.println("breath fire");
        return true;
    }
}