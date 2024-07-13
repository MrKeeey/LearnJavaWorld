package PracticeTasks;

import java.util.*;

public class LC22_generateParenthesis {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
        System.out.println(generateParenthesis2(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        Queue<CountParenthesis> makeResult = new LinkedList<>();

        makeResult.offer(new CountParenthesis("", 0, 0));
        while (!makeResult.isEmpty()) {
            CountParenthesis cp = makeResult.poll();
            if (cp.currentStr.length() == n * 2) {
                result.add(cp.currentStr);
            } else {
                if (cp.countOpenP < n) {
                    makeResult.offer(new CountParenthesis(cp.currentStr + "(", cp.countOpenP + 1, cp.countCloseP));
                }
                if (cp.countCloseP < cp.countOpenP) {
                    makeResult.offer(new CountParenthesis(cp.currentStr + ")", cp.countOpenP, cp.countCloseP + 1));
                }
            }
        }

        return result;
    }

    private static class CountParenthesis {
        String currentStr;
        int countOpenP;
        int countCloseP;

        CountParenthesis(String currentStr, int countOpenP, int countCloseP) {
            this.currentStr = currentStr;
            this.countOpenP = countOpenP;
            this.countCloseP = countCloseP;
        }
    }

    public static List<String> generateParenthesis2(int n) {
        ArrayList<String> result = new ArrayList<>();
        generateResult(result, "", 0, 0, n);
        return result;
    }

    private static void generateResult(ArrayList<String> result, String currentStr,
                                       int countOpenP, int countCloseP, int n) {
        if (currentStr.length() == n * 2) {
            result.add(currentStr);
        } else {
            if (countOpenP < n) {
                generateResult(result, currentStr + "(", countOpenP + 1, countCloseP, n);
            }
            if (countCloseP < countOpenP) {
                generateResult(result, currentStr + ")", countOpenP, countCloseP + 1, n);
            }
        }
    }
}
