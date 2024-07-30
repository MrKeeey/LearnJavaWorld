package PracticeTasks;

public class LC42_trap {
    public static void main(String[] args) {
        int[] array = {4, 2, 0, 3, 2, 5};
        System.out.println(trap(array));
    }

    public static int trap(int[] height) {
        int water = 0;
        int n = height.length;
        int[] maxLeftWall = new int[n];
        int[] maxRightWall = new int[n];

        maxLeftWall[0] = height[0];
        for (int i = 1; i < n; i++) {
            maxLeftWall[i] = Math.max(maxLeftWall[i - 1], height[i]);
        }

        maxRightWall[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxRightWall[i] = Math.max(maxRightWall[i + 1], height[i]);
        }

        for (int i = 0; i < n; i++) {
            water += (Math.min(maxLeftWall[i], maxRightWall[i]) - height[i]);
        }
        return water;
    }
}
