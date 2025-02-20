package PracticeTasks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC1980_findDifferentBinaryString {

    public String findDifferentBinaryString(String[] nums) {
        return generate(
                nums.length,
                new StringBuilder(),
                new HashSet<>(Arrays.asList(nums))
        );
    }

    private String generate(int n, StringBuilder currStr, Set<String> setNum) {
        if (currStr.length() == n) {
            String candidate = currStr.toString();
            if (!setNum.contains(candidate)) {
                return candidate;
            }
            return null;
        }

        for (int i = 0; i < 2; i++) {
            currStr.append(i);
            String result = generate(n, currStr, setNum);
            if (result != null) return result;
            currStr.deleteCharAt(currStr.length() - 1);
        }

        return null;
    }

    //genius method канторовской диагонализации (Cantor's diagonalization argument)
    public String findDifferentBinaryString2(String[] nums) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < nums.length; i++) {
            result.append(nums[i].charAt(i) == '0' ? '1' : '0');
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String[] array = {"111", "000", "001"};
        System.out.println(new LC1980_findDifferentBinaryString().findDifferentBinaryString(array));
        System.out.println(new LC1980_findDifferentBinaryString().findDifferentBinaryString2(array));
    }
}
