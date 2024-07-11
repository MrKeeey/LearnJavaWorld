package HeadFirst.chapter14;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Pond implements Serializable {
    transient public Duck duck = new Duck();            //transient = skip

    public static void main(String[] args) {

        Pond myPond = new Pond();

        try {
            FileOutputStream fs = new FileOutputStream("Z:\\NW\\y\\LearnWorld\\IdeaProjects\\LearnWithBook\\chapter14\\pond.res");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(myPond);
            os.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
class Duck {
    String meow;

    public void setMeow(String str){
        meow = str;
    }

}
