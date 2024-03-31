package PracticeTasks;


public class LC_IncreasingTriplet {
    public static void main(String[] args) {
        int[] array = {20, 100, 10, 12, 5, 13};
        System.out.println(increasingTriplet(array));
        System.out.println(increasingTriplet2(array));
    }

    public static boolean increasingTriplet(int[] nums) {
        int i = 0;
        int j;
        int k;
        int n = nums.length - 1;
        if (n < 2) {
            return false;
        }
        while (i <= n - 2) {
            j = i + 1;
            while (j <= n - 1) {
                if (nums[i] < nums[j]) {
                    k = j + 1;
                    while (k <= n) {
                        if (nums[j] < nums[k]) {
                            return true;
                        } else {
                            k++;
                        }
                    }
                } else {
                    j++;
                }
                j++;
            }
            i++;
        }
        return false;
    }

    public static boolean increasingTriplet2(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int first = nums[0];
        int second = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
