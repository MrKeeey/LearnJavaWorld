package PracticeTasks;

public class LC1684_countConsistentStrings {
    public static void main(String[] args) {
        System.out.println(new LC1684_countConsistentStrings().countConsistentStrings("cad", new String[]{"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"}));
    }

    public int countConsistentStrings(String allowed, String[] words) {
        int count = words.length;

        boolean[] isAllowedChars = new boolean[26];
        for (char c : allowed.toCharArray()) {
            isAllowedChars[c - 'a'] = true;
        }

        for (String s : words) {
            for (char c : s.toCharArray()) {
                if (!isAllowedChars[c - 'a']) {
                    count--;
                    break;
                }
            }
        }

        return count;
    }
}
