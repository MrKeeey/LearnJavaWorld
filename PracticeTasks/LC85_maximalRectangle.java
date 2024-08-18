package PracticeTasks;

public class LC85_maximalRectangle {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        System.out.println(maximalRectangle(matrix));
    }

    public static int maximalRectangle(char[][] matrix) {
        int n = matrix[0].length;
        int[] result = new int[n];
        int maxArea = 0;
        for (char[] chars : matrix) {
            for (int j = 0; j < n; j++) {
                result[j] = (chars[j] == '1') ? result[j] + 1 : 0;
            }
            for (int j = 0; j < n; j++) {
                for (int k = j, minHeight = Integer.MAX_VALUE; k < n; k++) {
                    minHeight = Math.min(minHeight, result[k]);
                    int area = minHeight * (k - j + 1);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }
}
