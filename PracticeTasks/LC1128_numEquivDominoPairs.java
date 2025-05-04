package PracticeTasks;

public class LC1128_numEquivDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] countNums = new int[100];

        for (int[] domino : dominoes) {
            int topNum = domino[0];
            int botNum = domino[1];
            int num;
            if (topNum < botNum) {
                num = topNum * 10 + botNum;
            } else {
                num = botNum * 10 + topNum;
            }
            countNums[num]++;
        }

        int count = 0;
        for (int num : countNums) {
            count += num * (num - 1) / 2;
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] dominoes = {{2, 1}, {2, 1}, {3, 5}, {4, 6}, {2, 2}};
        System.out.println(new LC1128_numEquivDominoPairs().numEquivDominoPairs(dominoes));
    }
}
