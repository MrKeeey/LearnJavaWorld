package PracticeTasks;

public class LC1358_numberOfSubstrings {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int left = 0, right = 0;
        int[] countChars = new int[3];
        int count = 0;

        while (right < n) {
            countChars[s.charAt(right) - 'a']++;
            while (countChars[0] > 0 && countChars[1] > 0 && countChars[2] > 0) {
                count += n - right;
                countChars[s.charAt(left) - 'a']--;
                left++;
            }
            right++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new LC1358_numberOfSubstrings().numberOfSubstrings("abcabc"));
    }
}
