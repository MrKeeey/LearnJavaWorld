package PracticeTasks;

public class LC2381_shiftingLetters {
    // a = 97  z = 122
    public String shiftingLetters(String s, int[][] shifts) {
        StringBuilder result = new StringBuilder();
        int n = s.length();
        int[] shiftsArray = new int[n + 1];
        for (int[] shift : shifts) {
            int from = shift[0];
            int to = shift[1];
            int direction = shift[2];

            shiftsArray[from] += direction == 1 ? 1 : -1;
            shiftsArray[to + 1] -= direction == 1 ? 1 : -1;
        }

        int temp = 0;
        for (int i = 0; i < n; i++) {
            temp += shiftsArray[i];
            shiftsArray[i] = temp;
        }

        for (int i = 0; i < n; i++) {
            int newChar = s.charAt(i) + (shiftsArray[i] % 26);

            if (newChar > 'z') {
                newChar -= 26;
            } else if (newChar < 'a') {
                newChar += 26;
            }
            result.append((char) newChar);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[][] array = {{0, 1, 0}, {1, 2, 1}, {0, 2, 1}};
        System.out.println(new LC2381_shiftingLetters().shiftingLetters("abc", array));
    }
}
