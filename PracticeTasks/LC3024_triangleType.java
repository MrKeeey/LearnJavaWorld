package PracticeTasks;

public class LC3024_triangleType {
    public String triangleType(int[] nums) {
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];

        if (a + b <= c || a + c <= b || b + c <= a) return "none";
        if (a == b && b == c) return "equilateral";
        if (a == b || a == c || b == c) return "isosceles";
        return "scalene";
    }

    public static void main(String[] args) {
        int[] array = {5, 3, 8};
        System.out.println(new LC3024_triangleType().triangleType(array));
    }
}
