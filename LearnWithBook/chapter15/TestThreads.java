package LearnWithBook.chapter15;

public class TestThreads {
    public static void main(String[] args) {
        ThreadOne t1 = new ThreadOne();
        ThreadTwo t2 = new ThreadTwo();
        Thread one = new Thread(t1);
        Thread two = new Thread(t2);
        one.start();
        two.start();
    }
}

class ThreadOne implements Runnable {
    Accum a = Accum.getAccum();
    public void run() {
        for (int i = 0; i < 98; i++) {
            a.updateCounter(1000);
            try {
                Thread.sleep(50);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        System.out.println("One " + a.getCount());
    }
}

class ThreadTwo implements Runnable {
    Accum a = Accum.getAccum();
    public void run() {
        for (int i = 0; i < 99; i++) {
            a.updateCounter(1);
            try {
                Thread.sleep(50);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        System.out.println("Two " + a.getCount());
    }
}

class Accum {
    private int counter = 0;
    private Accum() { }
    private static Accum a = new Accum();
    public int getCount() {
        return counter;
    }
    public void updateCounter(int add) {
        counter += add;
    }
    public static Accum getAccum() {
        return a;
    }
}