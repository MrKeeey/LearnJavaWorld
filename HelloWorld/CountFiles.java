package HelloWorld;

import java.io.File;

public class CountFiles {
    public static void main(String[] args) {
        try {
            File file[] =  new File("Z:\\ICloud\\Drive\\ILCE-7RM3\\Minsk").listFiles();
            int count = file.length;
            System.out.println("Total no. of files : " + count);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
