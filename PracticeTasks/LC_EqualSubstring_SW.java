package PracticeTasks;

public class LC_EqualSubstring_SW {
    public static void main(String[] args) {
        System.out.println(equalSubstring("krrgw", "zjxss", 19));
    }

    public static int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] costs = new int[n];

        for (int i = 0; i < n; i++) {
            costs[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        int left = 0;
        int maxLen = 0;
        int sum = 0;
        for (int right = 0; right < n; right++) {
            sum += costs[right];
            while (sum > maxCost) {
                sum -= costs[left];
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
