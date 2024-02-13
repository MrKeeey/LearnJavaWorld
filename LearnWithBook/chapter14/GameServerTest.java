package LearnWithBook.chapter14;

import java.io.*;

public class GameServerTest {

    public static void main(String[] args) {

        GameCharacter one = new GameCharacter(50, "Elf", new String[] {"Bow", "Sword", "Dust"});
        GameCharacter two = new GameCharacter(200, "Troll", new String[] {"Bare hands", "Big Axe"});
        GameCharacter three = new GameCharacter(120, "Magician", new String[] {"Spells", "Invisibility"});

        try {

            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Z:\\NW\\y\\LearnWorld\\IdeaProjects\\LearnWithBook\\chapter14\\game.meow"));
            os.writeObject(one);
            os.writeObject(two);
            os.writeObject(three);

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        one = null;
        two = null;
        three = null;

        try {

            ObjectInputStream is = new ObjectInputStream(new FileInputStream("Z:\\NW\\y\\LearnWorld\\IdeaProjects\\LearnWithBook\\chapter14\\game.meow"));
            GameCharacter oneRestore = (GameCharacter) is.readObject();
            GameCharacter twoRestore = (GameCharacter) is.readObject();
            GameCharacter threeRestore = (GameCharacter) is.readObject();

            System.out.println("One's type: " + oneRestore.getType());
            System.out.println("Two's power: " + twoRestore.getPower());
            System.out.println("Three's weapons: " + threeRestore.getWeapons());

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

class GameCharacter implements Serializable {

    int power;
    String type;
    String[] weapons;

    public GameCharacter (int p, String t, String[] w) {
        power = p;
        type = t;
        weapons = w;
    }

    public int getPower() {
        return power;
    }

    public String getType() {
        return type;
    }

    public String getWeapons() {
        String weaponList = "";
        for (String weapon : weapons) {
            weaponList += weapon + " ";
        }
        return weaponList;
    }
}
