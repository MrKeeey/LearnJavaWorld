package PracticeTasks;

public class LC1395_numTeams {
    public static void main(String[] args) {
        int[] array = {2, 5, 3, 4, 1};
        System.out.println(numTeams(array));
        System.out.println(numTeams2(array));
    }

    public static int numTeams(int[] rating) {
        int countTeams = 0;
        int n = rating.length;

        for (int mid = 1; mid < n - 1; mid++) {
            int leftSmaller = 0;
            int rightLarger = 0;
            for (int left = mid - 1; left >= 0; left--) {
                if (rating[left] < rating[mid]) {
                    leftSmaller++;
                }
            }
            for (int right = mid + 1; right < n; right++) {
                if (rating[right] > rating[mid]) {
                    rightLarger++;
                }
            }
            countTeams += leftSmaller * rightLarger;
            int leftLarger = mid - leftSmaller;
            int rightSmaller = n - 1 - mid - rightLarger;
            countTeams += leftLarger * rightSmaller;
        }
        return countTeams;
    }

    public static int numTeams2(int[] rating) {
        int countTeams = 0;
        int n = rating.length;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (rating[i] < rating[j]) {
                        if (rating[j] < rating[k]) countTeams++;
                    } else {
                        if (rating[j] > rating[k]) countTeams++;
                    }
                }
            }
        }

        return countTeams;
    }
}
