package PracticeTasks;

public class LC2843_countSymmetricIntegers {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;

        for (int i = low; i <= high; i++) {
            String num = String.valueOf(i);
            int n = num.length();
            if (n % 2 != 0) continue;

            int half = n / 2;
            int firstHalf = 0;
            int secondHalf = 0;

            for (int j = 0; j < half; j++) {
                firstHalf += num.charAt(j);
                secondHalf += num.charAt(half + j);
            }

            if (firstHalf == secondHalf) count++;
        }

        return count;
    }

    //faster
    public int countSymmetricIntegers2(int low, int high) {
        int count = 0;

        for (int num = low; num <= high; num++) {
            if (num < 100 && num % 11 == 0) {
                count++;
            } else if (num >= 1000 && num < 10000) {
                int sumFirstHalf = num / 1000 + (num % 1000) / 100;
                int sumSecondHalf = (num % 100) / 10 + (num % 10);

                if (sumFirstHalf == sumSecondHalf) count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new LC2843_countSymmetricIntegers().countSymmetricIntegers(1200, 1230));
        System.out.println(new LC2843_countSymmetricIntegers().countSymmetricIntegers2(1200, 1230));
    }
}
