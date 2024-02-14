package LearnWithBook.chapter15;

class MyRunnable implements Runnable {
    public void run() {
        go();
        System.out.println("run");
    }

    public void go() {

        try {
            Thread.sleep(1000);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        doMore();
        System.out.println("go");

    }

    public void doMore() {
        System.out.println("doMore");
    }
}
public class ThreadTester {
    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            Runnable threadJob = new MyRunnable();
            Thread myThread = new Thread(threadJob);
            myThread.start();
            System.out.println("Back to main");
        }
    }
}
