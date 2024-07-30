package PracticeTasks;

public class LC345_reverseVowels {
    public static void main(String[] args) {
        String str = "race car";
        System.out.println(reverseVowels(str));
        System.out.println(reverseVowels2(str));
    }

    public static String reverseVowels(String s) {
        StringBuilder str = new StringBuilder(s);
        int n = str.length() - 1;
        int count = 0;
        while (count < n) {
            if (str.charAt(count) == 'a' || str.charAt(count) == 'e' || str.charAt(count) == 'i' || str.charAt(count) == 'o' || str.charAt(count) == 'u' || str.charAt(count) == 'A' || str.charAt(count) == 'E' || str.charAt(count) == 'I' || str.charAt(count) == 'O' || str.charAt(count) == 'U') {
                while (n > count) {
                    if (str.charAt(n) == 'a' || str.charAt(n) == 'e' || str.charAt(n) == 'i' || str.charAt(n) == 'o' || str.charAt(n) == 'u' || str.charAt(n) == 'A' || str.charAt(n) == 'E' || str.charAt(n) == 'I' || str.charAt(n) == 'O' || str.charAt(n) == 'U') {
                        char tmp = str.charAt(count);
                        str.setCharAt(count, s.charAt(n));
                        str.setCharAt(n, tmp);
                        n--;
                        break;
                    }
                    n--;
                }
            }
            count++;
        }
        return str.toString();
    }

    public static String reverseVowels2(String s) {
        StringBuilder str = new StringBuilder(s);
        boolean[] symbols = new boolean[123];
        for (char c : "aeiouAEIOU".toCharArray()){
            symbols[c] = true;
        }
        int count = 0;
        int n = s.length() - 1;
        while (count < n) {
            while (count < n && !symbols[s.charAt(count)]) {
                count++;
            }
            while (count < n && !symbols[s.charAt(n)]) {
                n--;
            }
            char tmp = s.charAt(count);
            str.setCharAt(count, s.charAt(n));
            str.setCharAt(n, tmp);
            count++;
            n--;
        }
        return str.toString();
    }
}
