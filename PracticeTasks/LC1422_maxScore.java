package PracticeTasks;

public class LC1422_maxScore {

    //better or not
    public int maxScore(String s) {
        int maxSum = 0;
        int countOnes = 0;
        int countZeros = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') countOnes++;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                countZeros++;
            } else {
                countOnes--;
            }
            maxSum = Math.max(maxSum, countZeros + countOnes);
        }

        return maxSum;
    }

    public int maxScore2(String s) {
        int maxSum = 0;
        int length = s.length();
        int[] sumOnes = new int[length];
        int tempSum = 0;

        for (int i = length - 1; i >= 0 ; i--) {
            if (s.charAt(i) == '1') {
                sumOnes[i] = tempSum++;
            } else {
                sumOnes[i] = tempSum;
            }
        }

        tempSum = 0;
        for (int i = 0; i < length - 1; i++) {
            if (s.charAt(i) == '0') {
                tempSum++;
            }
            maxSum = Math.max(maxSum, tempSum + sumOnes[i]);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(new LC1422_maxScore().maxScore("011101"));
        System.out.println(new LC1422_maxScore().maxScore2("00"));
    }
}
