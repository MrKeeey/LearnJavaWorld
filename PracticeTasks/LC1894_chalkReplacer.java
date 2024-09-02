package PracticeTasks;

public class LC1894_chalkReplacer {
    public static void main(String[] args) {
        int[] array = {3, 4, 1, 2};
        System.out.println(chalkReplacer(array, 27));
    }

    public static int chalkReplacer(int[] chalk, int k) {
        long chalkSum = 0;
        for (int countChalk : chalk) {
            chalkSum += countChalk;
        }

        long chalkLeft = k % chalkSum;
        int index = 0;
        if (chalkLeft != 0) {
            while (chalkLeft >= 0) {
                chalkLeft -= chalk[index++];
            }
            index--;
        }

        return index;
    }
}
