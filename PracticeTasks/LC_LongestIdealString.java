package PracticeTasks;

public class LC_LongestIdealString {
    public static void main(String[] args) {
        System.out.println(longestIdealString("acfgbd", 2));
        System.out.println(longestIdealString2("acfgbd", 2));
    }

    public static int longestIdealString(String s, int k) {
        int resultLength = 0;
        int[] alphabet = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            for (int j = index; j >= 0 && j >= index - k; j--) {
                alphabet[index] = Math.max(alphabet[index], alphabet[j] + 1);
            }
            for (int j = index + 1; j < 26 && j < index + k; j++) {
                alphabet[index] = Math.max(alphabet[index], alphabet[j] + 1);
            }
            resultLength = Math.max(resultLength, alphabet[index]);
        }

        return resultLength;
    }

    public static int longestIdealString2(String s, int k) {
        int[] array = new int[27];

        for (int i = s.length() - 1; i >= 0; i--) {
            int idx = s.charAt(i) - 'a';
            int left = Math.max((idx - k), 0);
            int right = Math.min((idx + k), 26);
            int max = Integer.MIN_VALUE;
            for (int j = left; j <= right; j++) {
                max = Math.max(max, array[j]);
            }
            array[idx] = max + 1;
        }

        int max = Integer.MIN_VALUE;
        for (int ele : array) {
            max = Math.max(ele, max);
        }

        return max;
    }
}
