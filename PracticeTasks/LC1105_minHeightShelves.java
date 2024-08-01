package PracticeTasks;

public class LC1105_minHeightShelves {
    public static void main(String[] args) {
        int[][] array = {{1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}};
        System.out.println(minHeightShelves(array, 4));
    }

    //not understanding how that working
    public static int minHeightShelves(int[][] books, int shelfWidth) {
        int[] dp = new int[books.length + 1];

        dp[0] = 0;
        dp[1] = books[0][1];
        for (int i = 2; i <= books.length; i++) {
            int currentW = shelfWidth - books[i - 1][0];
            int maxH = books[i - 1][1];
            dp[i] = dp[i - 1] + books[i - 1][1];

            int j = i - 1;
            while (j > 0 && currentW - books[j - 1][0] >= 0) {
                maxH = Math.max(maxH, books[j - 1][1]);
                currentW -= books[j - 1][0];
                dp[i] = Math.min(dp[i], maxH + dp[j - 1]);
                j--;
            }
        }

        return dp[books.length];
    }
}
