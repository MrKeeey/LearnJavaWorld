package PracticeTasks;


public class LC_LongestSubstring {
    public static void main(String[] args) {
        String s = "abcbada";
        System.out.println(lengthOfLongestSubstring2(s));
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        StringBuilder result = new StringBuilder();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (result.toString().contains(String.valueOf(s.charAt(i)))) {
                max = Math.max(max, result.length());
                while (result.toString().contains(String.valueOf(s.charAt(i)))) {
                    result.deleteCharAt(0);
                }
                result.append(s.charAt(i));
            } else {
                result.append(s.charAt(i));
                max = Math.max(max, result.length());
            }
        }
        return max;
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        String result = "";
        int max = 0;
        for (int j = 0; j < s.length(); j++) {
            for (int i = j; i < s.length(); i++) {
                if (result.contains(String.valueOf(s.charAt(i)))) {
                    max = Math.max(max, result.length());
                    result = String.valueOf(s.charAt(i));
                } else {
                    result += s.charAt(i);
                    if (i == s.length() - 1) {
                        max = Math.max(max, result.length());
                    }
                }
            }
            result = "";
        }
        return max;
    }
}
