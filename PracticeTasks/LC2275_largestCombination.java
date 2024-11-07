package PracticeTasks;

public class LC2275_largestCombination {

    public int largestCombination(int[] candidates) {
        int count = 0;
        int[] bitCandidates = new int[24];

        for (int candidate : candidates) {
            String bitCode = Integer.toBinaryString(candidate);
            int length = bitCode.length();
            for (int i = 0; i < bitCode.length(); i++) {
                if (bitCode.charAt(i) == '1') {
                    bitCandidates[24 - length]++;
                    //count = Math.max(count, bitCandidates[24 - length]);
                }
                length--;
            }
        }

        for (int c : bitCandidates) {
            count = Math.max(c, count);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] candidates = {8, 8};
        System.out.println(new LC2275_largestCombination().largestCombination(candidates));
    }
}
