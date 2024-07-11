package HeadFirst.chapter2;

public class Drums {
    boolean Snare = true;
    boolean TopHat = true;
    void playSnare(){
        System.out.println("bang bang ba-bang");
    }

    void playTopHat(){
        System.out.println("ding ding da-ding");
    }
}

class TestDrums {
    public static void main(String[] args) {

        Drums drums = new Drums();

        drums.playSnare();
        drums.Snare = false;
        drums.playTopHat();

        if (drums.Snare){
            drums.playSnare();
        }
    }
}