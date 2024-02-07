package LearnWithBook.chapter14;

import java.io.*;

public class Box implements Serializable {

    @Serial
    private static final long serialVersionUID = -8861974339969088104L;
    private int width, height;

    public void setWidth(int w) {
        width = w;
    }

    public void setHeight(int h) {
        height = h;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public static void main(String[] args) {

        Box myBox = new Box();
        myBox.setWidth(120);
        myBox.setHeight(345);
        System.out.println(myBox.getWidth() + " " + myBox.getHeight());

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Z:\\NW\\y\\LearnWorld\\LearnWithBook\\chapter14\\box.res"))) {
            oos.writeObject(myBox);
            //don't need oos.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        myBox.setWidth(0);
        myBox.setHeight(0);
        //myBox = null;
        System.out.println(myBox.getWidth() + " " + myBox.getHeight());

        try {

            FileInputStream fileInput = new FileInputStream("Z:\\NW\\y\\LearnWorld\\LearnWithBook\\chapter14\\box.res");
            ObjectInput is = new ObjectInputStream(fileInput);
            Object myBoxRestore = is.readObject();
            myBox = (Box) myBoxRestore;                 //Box myBoxRestore = (Box) is.readObject(); myBoxRestore.getWidth()
            is.close();

            System.out.println(myBox.getWidth() + " " + myBox.getHeight());

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
