package PracticeTasks;

public class LC2486_appendCharacters {
    public static void main(String[] args) {
        System.out.println(appendCharacters("coaching", "coding"));
    }

    public static int appendCharacters(String s, String t) {
        int result = t.length();

        for (int i = 0, j = 0; j < s.length() && i < t.length(); j++) {
            if (t.charAt(i) == s.charAt(j)) {
                result--;
                i++;
            }
        }
        return result;
    }
}
