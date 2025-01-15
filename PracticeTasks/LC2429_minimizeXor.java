package PracticeTasks;

public class LC2429_minimizeXor {
    public int minimizeXor(int num1, int num2) {
        int result = 0;
        int targetBitCount = Integer.bitCount(num2);
        int setBitCount = 0;
        int currentBit = 31;

        while (setBitCount < targetBitCount) {
            if (isSet(num1, currentBit) || (targetBitCount - setBitCount) > currentBit) {
                result = setBit(result, currentBit);
                setBitCount++;
            }
            currentBit--;
        }

        return result;
    }

    private boolean isSet(int x, int bit) {
        return (x & (1 << bit)) != 0;
    }

    private int setBit(int x, int bit) {
        return x | (1 << bit);
    }

    public static void main(String[] args) {
        System.out.println(new LC2429_minimizeXor().minimizeXor(3, 5));
    }
}
