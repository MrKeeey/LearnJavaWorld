package PracticeTasks;

public class LC2140_mostPoints {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];

        for (int i = n - 1; i >= 0; i--) {
            int next = i + questions[i][1] + 1;
            long take = questions[i][0] + (next < n ? dp[next] : 0);
            long skip = (i < n - 1) ? dp[i + 1] : 0;
            dp[i] = Math.max(take, skip);
        }

        return dp[0];
    }

    public long mostPoints2(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];

        for (int i = n - 1; i >= 0; i--) {
            int next = i + questions[i][1] + 1;

            if (next < n) {
                dp[i] = Math.max(dp[i + 1], questions[i][0] + dp[next]);
            } else {
                dp[i] = Math.max(
                        questions[i][0],
                        i < n - 1 ? dp[i + 1] : 0
                );
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        int[][] exams = {{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}};
        System.out.println(new LC2140_mostPoints().mostPoints(exams));
        System.out.println(new LC2140_mostPoints().mostPoints2(exams));
    }
}
