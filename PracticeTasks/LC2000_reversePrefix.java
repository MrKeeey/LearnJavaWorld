package PracticeTasks;

public class LC2000_reversePrefix {
    public static void main(String[] args) {
        System.out.println(reversePrefix("abcdefd", 'q'));
    }

    public static String reversePrefix(String word, char ch) {
        StringBuilder str = new StringBuilder(word);
        int count = 0;
        for (int i = word.indexOf(ch); i >= 0; i--) {
            str.setCharAt(count++, word.charAt(i));
        }
        return str.toString();
    }
}
