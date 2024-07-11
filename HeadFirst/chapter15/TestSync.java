package HeadFirst.chapter15;

public class TestSync implements Runnable {
    private int balance;
    public void run() {
        for (int i = 0; i < 10; i++) {
            increment();
        }
    }

    public synchronized void increment() {
        int i = balance;
        balance = i + 1;
        System.out.println(" Balance: " + balance);
    }
}

class TestSyncTest {
    public static void main(String[] args) {
        TestSync job = new TestSync();
        Thread a = new Thread(job);
        Thread b = new Thread(job);
        a.start();
        b.start();
    }
}
