package PracticeTasks;

public class LC2182_repeatLimitedString {
    public String repeatLimitedString(String s, int repeatLimit) {
        StringBuilder result = new StringBuilder();
        int[] countSymbols = new int[26];

        for (char c : s.toCharArray()) {
            countSymbols[c - 'a']++;
        }

        for (int index = 25; index >= 0 ; index--) {
            if (countSymbols[index] > repeatLimit) {
                int use = repeatLimit;
                while (use > 0) {
                    result.append((char)('a' + index));
                    use--;
                }
                countSymbols[index] -= repeatLimit;

                int prevIndex = index - 1;
                while (prevIndex >=0 && countSymbols[prevIndex] == 0) {
                    prevIndex--;
                }

                if (prevIndex < 0) break;

                result.append((char)('a' + prevIndex));
                countSymbols[prevIndex]--;
                index++;

            } else {
                while (countSymbols[index] > 0) {
                    result.append((char)('a' + index));
                    countSymbols[index]--;
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LC2182_repeatLimitedString().repeatLimitedString("cczazcc", 3));
    }
}
