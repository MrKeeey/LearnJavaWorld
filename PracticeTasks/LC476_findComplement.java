package PracticeTasks;

public class LC476_findComplement {
    public static void main(String[] args) {
        System.out.println(findComplement(1));
    }

    public static int findComplement(int num) {
        int result = 0;
        int index = 0;

        while (num != 0) {
            int swap = num % 2;
            if (swap == 0) {
                swap = 1;
            } else {
                swap = 0;
            }
            num /= 2;
            result += swap * Math.pow(2, index++);
        }

        return result;
    }
}
