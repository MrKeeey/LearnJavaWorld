package PracticeTasks;

public class LC11_maxArea {
    public static void main(String[] args) {
        int[] water = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(water));
    }

    public static int maxArea(int[] height) {
        int resultMaxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int currentMin = Math.min(height[left], height[right]);
            resultMaxArea = Math.max(currentMin * (right - left), resultMaxArea);
            while (left < right && height[left] <= currentMin) {
                left++;
            }
            while (left < right && height[right] <= currentMin){
                right--;
            }
        }
        return resultMaxArea;
    }
}
