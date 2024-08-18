package PracticeTasks;

public class LC1614_maxDepth {
    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
        System.out.println(maxDepth(s));
    }

    public static int maxDepth(String s) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
                if (max < count) {
                    max = count;
                }
            }
            if (s.charAt(i) == ')'){
                count--;
            }
        }
        return max;
    }
}