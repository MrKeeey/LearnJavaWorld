package PracticeTasks;

public class LC1404_numSteps {
    public static void main(String[] args) {
        System.out.println(numSteps2("1111110011101010110011100100101110010100101110111010111110110010"));
        System.out.println(numSteps("1111110011101010110011100100101110010100101110111010111110110010"));
    }

    public static int numSteps(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder(s);

        while (sb.length() - 1 >= 1) {
            int i = sb.length() - 1;
            if (sb.charAt(i) == '1') {
                int j = i;
                while (j >= 0) {
                    if (sb.charAt(j) == '1') {
                        sb.setCharAt(j, '0');
                    } else {
                        sb.setCharAt(j, '1');
                        break;
                    }
                    j--;
                }
                if (sb.charAt(0) == '0') {
                    sb.append('0');
                    sb.setCharAt(0, '1');
                }
            } else {
                sb.deleteCharAt(i);
            }
            count++;
        }
        return count;
    }

    public static int numSteps2(String s) {
        int count = 0;
        int n = s.length() - 1;
        long num = 0;

        for (int i = 0; i <= n; i++) {
            num += Long.parseLong(String.valueOf(s.charAt(i))) << (n - i);
        }

        while (num > 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num++;
            }
            count++;
        }

        return count;
    }
}
