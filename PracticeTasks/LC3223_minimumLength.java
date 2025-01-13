package PracticeTasks;

public class LC3223_minimumLength {

    public int minimumLength(String s) {
        int result = 0;
        int[] freqs = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freqs[s.charAt(i) - 'a']++;
        }

        for (int freq : freqs) {
            if (freq <= 2) {
                result += freq;
            } else {
                if (freq % 2 == 0) {
                    result += 2;
                } else {
                    result += 1;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LC3223_minimumLength().minimumLength("abaacbcbb"));
    }
}
