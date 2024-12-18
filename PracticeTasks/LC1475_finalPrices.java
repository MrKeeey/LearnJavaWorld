package PracticeTasks;

import java.util.Arrays;

public class LC1475_finalPrices {
    public static int[] finalPrices(int[] prices) {
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] >= prices[j]) {
                    prices[i] -= prices[j];
                    break;
                }
            }
        }
        return prices;
    }

    public static void main(String[] args) {
        int[] array = {10,1,1,6};
        System.out.println(Arrays.toString(finalPrices(array)));
    }
}
