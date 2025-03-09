package PracticeTasks;

public class LC3208_numberOfAlternatingGroups {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int[] colorsCircle = new int[n + k - 1];
        System.arraycopy(colors, 0, colorsCircle, 0, n);
        System.arraycopy(colors, 0, colorsCircle, n, k - 1);

        int count = 1;
        int result = 0;
        for (int i = 1; i < n + k - 1; i++) {
            if (colorsCircle[i] != colorsCircle[i - 1]) {
                count++;
            } else {
                count = 1;
            }

            if (count >= k) result++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] colors = {0, 1, 0, 1, 0};
        System.out.println(new LC3208_numberOfAlternatingGroups().numberOfAlternatingGroups(colors, 3));
    }
}
