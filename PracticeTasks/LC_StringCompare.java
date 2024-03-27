package PracticeTasks;

public class LC_StringCompare {
    public static void main(String[] args) {
        System.out.println(backspaceCompare("a##c", "#a#c"));
        System.out.println(preparedString("a##c").equals(preparedString("#a#c")));
    }

    private static boolean backspaceCompare(String s, String t) {
        StringBuilder firstStr = new StringBuilder(s);
        StringBuilder secondStr = new StringBuilder(t);

        int i = 0;
        while (i != firstStr.length()) {
            if (firstStr.charAt(i) == '#') {
                if (i == 0) {
                    firstStr.delete(0, 1);
                    i = 0;
                    continue;
                } else {
                    firstStr.delete(i - 1, i + 1);
                    i -= 2;
                    if (i < 0) {
                        i = 0;
                        continue;
                    }
                }
            }
            i++;
        }

        i = 0;
        while (i != secondStr.length()) {
            if (secondStr.charAt(i) == '#') {
                if (i == 0) {
                    secondStr.delete(0, 1);
                    i = 0;
                    continue;
                } else {
                    secondStr.delete(i - 1, i + 1);
                    i -= 2;
                    if (i < 0) {
                        i = 0;
                        continue;
                    }
                }
            }
            i++;
        }
        return firstStr.toString().contentEquals(secondStr);
        //return preparedString(s).equals(preparedString(t));
    }

    private static String preparedString (String str) {
        StringBuilder prepareStr = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c != '#') {
                prepareStr.append(c);
            } else {
                if (prepareStr.length() != 0) {
                    prepareStr.deleteCharAt(prepareStr.length() - 1);
                }
            }
        }
        return prepareStr.toString();
    }
}
