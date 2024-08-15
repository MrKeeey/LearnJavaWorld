package PracticeTasks;

public class LC860_lemonadeChange {
    public static void main(String[] args) {
        int[] array = {5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 20, 5, 20, 5};
        System.out.println(lemonadeChange(array));
    }

    public static boolean lemonadeChange(int[] bills) {
        int count5 = 0;
        int count10 = 0;

        for (int bill : bills) {
            if (bill == 5) {
                count5++;
            }
            if (bill == 10) {
                count10++;
            }
            
            int change = bill - 5;
            
            while (change != 0) {
                if (change == 5) {
                    if (count5 > 0) {
                        count5--;
                        change -= 5;
                    } else {
                        return false;
                    }
                }
                if (change == 15) {
                    if (count10 > 0) {
                        count10--;
                        change -= 10;
                    } else if (count5 >= 3) {
                        count5 -= 3;
                        change -= 15;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
