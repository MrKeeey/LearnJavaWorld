package PracticeTasks;

public class LC38_countAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }

    public static String countAndSay(int n) {
        String result = "1";
        for (int i = 0; i < n - 1; i++) {
            result = makeNewStr(result);
        }
        return result;
    }

    private static String makeNewStr(String str) {
        StringBuilder newString = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            int count = 0;
            char c = str.charAt(i);

            while (i < str.length() && c == str.charAt(i)) {
                count++;
                i++;
            }
            i--;
            newString.append(count).append(str.charAt(i));
        }
        return newString.toString();
    }
}
