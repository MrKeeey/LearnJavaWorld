package PracticeTasks;

public class LC402_removeKdigits {
    public static void main(String[] args) {
        String s = "10001";
        System.out.println(removeKdigits(s, 4));
    }

    public static String removeKdigits(String num, int k) {
        if (k == 0) return num;
        if (num.length() <= k) return "0";
        StringBuilder sb = new StringBuilder();
        sb.append(num.charAt(0));
        for (int i = 1; i < num.length(); i++) {
            if (k > 0 && sb.length() > 0 && num.charAt(i) < sb.charAt(sb.length() - 1)) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
                i--;
                continue;
            }
            sb.append(num.charAt(i));
        }
        while (k > 0 & sb.length()> 0) {
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        if (sb.length() == 0) return "0";
        return sb.toString();
    }
}
