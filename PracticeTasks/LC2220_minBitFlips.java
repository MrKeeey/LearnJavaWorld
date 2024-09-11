package PracticeTasks;

public class LC2220_minBitFlips {
    public static void main(String[] args) {
        System.out.println(new LC2220_minBitFlips().minBitFlips(10, 1));
        System.out.println(new LC2220_minBitFlips().minBitFlips2(10, 1));
        System.out.println(new LC2220_minBitFlips().minBitFlips3(10, 1));
    }

    public int minBitFlips(int start, int goal) {
        int count = 0;
        StringBuilder startNum = new StringBuilder(Integer.toBinaryString(start));
        StringBuilder goalNum = new StringBuilder(Integer.toBinaryString(goal));
        int startLength = startNum.length();
        int goalLength = goalNum.length();

        if (startLength < goalLength) {
            while (startLength != goalLength) {
                startNum.insert(0, "0");
                startLength++;
            }
        } else if (startLength > goalLength) {
            while (goalLength != startLength) {
                goalNum.insert(0, "0");
                goalLength++;
            }
        }

        for (int i = 0; i < startLength; i++) {
            if (startNum.charAt(i) != goalNum.charAt(i)) {
                count++;
            }
        }

        return count;
    }

    public int minBitFlips2(int start, int goal) {
        int count = 0;

        while (start > 0 || goal > 0) {
            int startRightBit = (start & 1);
            int goalRightBit = (goal & 1);

            count += startRightBit != goalRightBit ? 1 : 0;

            start = start > 0 ? start >> 1 : 0;
            goal = goal > 0 ? goal >> 1 : 0;

        }

        return count;
    }

    public int minBitFlips3(int start, int goal) {
        int count = 0;
        String temp = Integer.toBinaryString(start ^ goal);
        for (char c : temp.toCharArray()) {
            if (c == '1') count++;
        }
        return count;
    }
}
