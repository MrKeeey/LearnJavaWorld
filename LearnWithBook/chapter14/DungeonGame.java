package LearnWithBook.chapter14;

import java.io.*;

class DungeonGame implements Serializable {

    public int x = 3;
    transient long y = 4;
    private short z = 5;

    int getX() {
        return x;
    }
    long getY() {
        return y;
    }
    short getZ() {
        return z;
    }
}
class DungeonTest {
    public static void main(String[] args) {

        DungeonGame d = new DungeonGame();
        System.out.println(d.getX() + d.getY() + d.getZ());

        try {

            FileOutputStream fos = new FileOutputStream("Z:\\NW\\y\\LearnWorld\\IdeaProjects\\LearnWithBook\\chapter14\\dg.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(d);
            oos.close();

            FileInputStream fis = new FileInputStream("Z:\\NW\\y\\LearnWorld\\IdeaProjects\\LearnWithBook\\chapter14\\dg.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            d = (DungeonGame) ois.readObject();
            ois.close();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        System.out.println(d.getX() + d.getY() + d.getZ());
    }
}
