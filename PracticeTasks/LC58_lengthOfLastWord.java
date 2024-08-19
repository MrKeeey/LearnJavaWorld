package PracticeTasks;

public class LC58_lengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("   moon  "));
        System.out.println(lengthOfLastWord2(" meow "));
    }

    public static int lengthOfLastWord(String s) {
        int count = 0;
        int index = s.length() - 1;
        while (s.charAt(index) == ' '){
            index--;
        }
        for (; index >= 0; index--) {
            if (s.charAt(index) != ' '){
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    public static int lengthOfLastWord2(String s) {
        String[] words = s.split(" ");
        if (words.length == 0) {
            return 0;
        }
        return words[words.length - 1].length();
    }
}
