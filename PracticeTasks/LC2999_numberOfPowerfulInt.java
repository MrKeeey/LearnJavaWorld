package PracticeTasks;

public class LC2999_numberOfPowerfulInt {

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        String startStr = Long.toString(start - 1);
        String finishStr = Long.toString(finish);
        return calculate(finishStr, limit, s) - calculate(startStr, limit, s);
    }

    //so hard don't understand
    private long calculate(String x, int limit, String s) {
        if (x.length() < s.length()) return 0;
        if (x.length() == s.length()) return x.compareTo(s) >= 0 ? 1 : 0;

        String suffix = x.substring(x.length() - s.length());
        long count = 0;
        int preLen = x.length() - s.length();

        for (int i = 0; i < preLen; i++) {
            int digit = x.charAt(i) - '0';
            if (limit < digit) {
                count += (long) Math.pow(limit + 1, preLen - i);
                return count;
            }
            count += (long) (digit) * (long) Math.pow(limit + 1, preLen - 1 - i);
        }
        if (suffix.compareTo(s) >= 0) count++;

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new LC2999_numberOfPowerfulInt().numberOfPowerfulInt(15398, 1424153842, 8, "218"));
    }
}
