package PracticeTasks;

public class LC2185_prefixCount {
    public int prefixCount(String[] words, String pref) {
        int count = 0;

        for (String word : words) {
            if (word.startsWith(pref)) count++;
//            slower
//            if (word.indexOf(pref) == 0) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        String[] words = {"pay", "attention", "practice", "attend"};
        System.out.println(new LC2185_prefixCount().prefixCount(words, "at"));
    }
}
