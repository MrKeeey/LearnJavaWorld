package PracticeTasks;

import java.util.Arrays;

public class LC1079_numTilePossibilities {

    public int numTilePossibilities(String tiles) {
        char[] chars = tiles.toCharArray();
        boolean[] used = new boolean[tiles.length()];
        int[] count = {0};

        Arrays.sort(chars);
        generate(chars, used, count);

        return count[0] - 1;
    }

    private void generate(char[] chars, boolean[] used, int[] count) {
        count[0]++;
        for (int i = 0; i < chars.length; i++) {
            if (used[i] || i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            generate(chars, used, count);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new LC1079_numTilePossibilities().numTilePossibilities("AAB"));
    }
}