package PracticeTasks;

public class LC3335_lengthAfterTransformations {
    public int lengthAfterTransformations(String s, int t) {
        int mod = 1_000_000_007;
        int[] countLetters = new int[26];
        for (char c : s.toCharArray()) {
            countLetters[c - 'a']++;
        }

        for (int i = 0; i < t; i++) {
            int[] temp = new int[26];
            temp[0] = countLetters[25];
            temp[1] = (countLetters[25] + countLetters[0]) % mod;
            System.arraycopy(countLetters, 1, temp, 2, 24);
            countLetters = temp;
        }

        int size = 0;
        for (int count : countLetters) {
            size = (size + count) % mod;
        }

        return size;
    }

    public static void main(String[] args) {
        System.out.println(new LC3335_lengthAfterTransformations().lengthAfterTransformations("abcyy", 2));
    }
}
