package PracticeTasks;

public class LC2226_maximumCandies {
    public int maximumCandies(int[] candies, long k) {
        int maxCandies = 0;
        for (int candy : candies) {
            maxCandies = Math.max(maxCandies, candy);
        }

        int left = 0;
        while (left < maxCandies) {
            int mid = (left + maxCandies + 1) / 2;
            if (allHaveCandies(candies, k, mid)) {
                left = mid;
            } else {
                maxCandies = mid - 1;
            }
        }

        return left;
    }

    private boolean allHaveCandies(int[] candies, long k, int numOfCandies) {
        long maxChildren = 0;
        for (int candy : candies) {
            maxChildren += candy / numOfCandies;
        }
        return maxChildren >= k;
    }


    public static void main(String[] args) {
        int[] array = {5, 2};
        System.out.println(new LC2226_maximumCandies().maximumCandies(array, 7));
    }
}
