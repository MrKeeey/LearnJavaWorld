package PracticeTasks;

public class LC1518_numWaterBottles {
    public static void main(String[] args) {
        System.out.println(numWaterBottles(15, 4));
    }

    public static int numWaterBottles(int numBottles, int numExchange) {
        int result = numBottles;

        while (numBottles >= numExchange) {
            int emptyBottlesLeft = numBottles % numExchange;
            numBottles = numBottles / numExchange;
            result += numBottles;
            numBottles += emptyBottlesLeft;
        }

        return result;
    }
}
