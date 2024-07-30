package PracticeTasks;

public class LC1653_minimumDeletions {
    public static void main(String[] args) {
        System.out.println(minimumDeletions("bbbaaaabbab"));
        System.out.println(minimumDeletions2("bbbaaaabbab"));
    }

    public static int minimumDeletions(String s) {
        int countToDelete = 0;
        int countB = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                countToDelete = Math.min(countToDelete + 1, countB);
            } else {
                countB++;
            }
        }
        return countToDelete;
    }

    //my method
    public static int minimumDeletions2(String s) {
        int n = s.length();
        int result = Integer.MAX_VALUE;;
        int countA = 0;

        for (int j = 0; j < n; j++) {
            if (s.charAt(j) == 'a') {
                countA++;
            }
        }
        if (countA == n || countA == 0) return 0;

        int countB = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                countA--;
            }
            result = Math.min(result, countA + countB);
            if (s.charAt(i) == 'b') {
                countB++;
            }
        }

        return result;
    }
}
