package HelloWorld;

import java.io.File;

public class CountFiles {
    public static void main(String[] args) {
        try {
            CountFiles countFiles = new CountFiles();
            countFiles.numberFilesFolders(new File("Z:\\ICloud\\Drive\\ILCE-7RM3\\Minsk"));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void numberFilesFolders(File folder) {

        File[] foldersEntry = folder.listFiles();
        System.out.println(folder + " ---" + foldersEntry.length);

        for (File entry: foldersEntry) {
            if (entry.isDirectory()) {
                numberFilesFolders(entry);
            }
        }

    }
}
