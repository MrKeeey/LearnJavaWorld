package LearnWithBook.chapter15;

class BankAccount {

    private int balance = 150;

    public int getBalance() {
        return balance;
    }
    public void withdraw(int amount) {
        balance = balance - amount;
    }
}
public class RyanAndMonikaJob implements Runnable {
    private BankAccount account = new BankAccount();

    public static void main(String[] args) {

        RyanAndMonikaJob theJob = new RyanAndMonikaJob();
        Thread one = new Thread(theJob);
        Thread two = new Thread(theJob);
        one.setName("Ryan");
        two.setName("Monika");
        one.start();
        two.start();

    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            makeWithdraw(10);
            if (account.getBalance() < 0) {
                System.out.println("Превышение лимита");
            }
        }
    }

    private synchronized void makeWithdraw (int amount) {
        if (account.getBalance() >= amount) {
            System.out.println(Thread.currentThread().getName() + " собирается снять деньги");
            try {
                System.out.println(Thread.currentThread().getName() + " идет подремать");
                Thread.sleep(500);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " просыпается");
            account.withdraw(amount);
            System.out.println(Thread.currentThread().getName() + " заканчиавет транзакцию");
            System.out.println("На балансе " + account.getBalance());
        } else {
            System.out.println("Извините, для килента " + Thread.currentThread().getName() + " недостаточно денег");
        }
    }
}
