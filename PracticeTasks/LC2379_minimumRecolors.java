package PracticeTasks;

public class LC2379_minimumRecolors {

    //faster + sliding windows
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int count = 0;
        int min;

        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') count++;
        }
        if (count == 0) return 0;
        min = count;

        for (int j = k; j < n; j++) {
            if (blocks.charAt(j - k) == 'W') count--;
            if (blocks.charAt(j) == 'W') count++;

            if (count == 0) return 0;
            if (min > count) min = count;
        }

        return min;
    }

    public int minimumRecolors2(String blocks, int k) {
        int n = blocks.length();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= n - k; i++) {
            int count = 0;
            for (int j = i; j < i + k; j++) {
                if (blocks.charAt(j) == 'W') count++;
            }

            if (count == 0) return 0;
            if (min > count) min = count;
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println(new LC2379_minimumRecolors().minimumRecolors("BWWWBB", 6));
        System.out.println(new LC2379_minimumRecolors().minimumRecolors2("BWWWBB", 6));
    }
}
