package PracticeTasks;

public class LC344_reverseString {
    public static void main(String[] args) {
        char[] array = {'h', 'e', 'l', 'l', 'o'};
        reverseString(array);
    }

    public static void reverseString(char[] s) {
        int right = s.length - 1;
        for (int left = 0; left < right; left++, right--) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
        System.out.println(s);
    }
}
