package LearnWithBook.chapter2;

public class DVDPlayer {

    boolean Record = false;

    void playDVD() {
        System.out.println("DVD playing...");
    }
    void recordDVD() {
        System.out.println("DVD recording...");
    }
}
class TestDVDPlayer {
    public static void main(String[] args) {

        DVDPlayer dvd = new DVDPlayer();
        dvd.Record = true;
        dvd.playDVD();

        if (dvd.Record){
            dvd.recordDVD();
        }
    }
}