package PracticeTasks;

public class LC1007_minDominoRotations {
    //faster
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int count = isPossible(tops[0], tops, bottoms);
        if (count != -1) return count;
        return isPossible(bottoms[0], tops, bottoms);
    }

    private int isPossible(int candidate, int[] tops, int[] bottoms) {
        int topSwaps = 0;
        int botSwaps = 0;

        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != candidate && bottoms[i] != candidate) return -1;
            if (tops[i] != candidate) topSwaps++;
            if (bottoms[i] != candidate) botSwaps++;
        }

        return Math.min(topSwaps, botSwaps);
    }

    //my version
    public int minDominoRotations2(int[] tops, int[] bottoms) {
        int len = tops.length;
        int topNum = tops[0];
        int botNum = bottoms[0];

        if (isPossibleToSwap(topNum, tops, bottoms)) {
            int topSwaps = 0;
            int botSwaps = 0;
            for (int i = 0; i < len; i++) {
                if (tops[i] != topNum) topSwaps++;
                if (bottoms[i] != topNum) botSwaps++;
            }

            return Math.min(topSwaps, botSwaps);

        } else if (topNum != botNum && isPossibleToSwap(botNum, tops, bottoms)) {
            int topSwaps = 0;
            int botSwaps = 0;
            for (int i = 0; i < len; i++) {
                if (tops[i] != botNum) topSwaps++;
                if (bottoms[i] != botNum) botSwaps++;
            }

            return Math.min(topSwaps, botSwaps);
        }

        return -1;
    }

    private boolean isPossibleToSwap(int num, int[] tops, int[] bottoms) {
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != num && bottoms[i] != num) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] t = {3, 5, 1, 2, 3};
        int[] b = {3, 6, 3, 3, 4};
        System.out.println(new LC1007_minDominoRotations().minDominoRotations(t, b));
        System.out.println(new LC1007_minDominoRotations().minDominoRotations2(t, b));
    }
}
