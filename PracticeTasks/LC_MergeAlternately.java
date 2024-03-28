package PracticeTasks;

public class LC_MergeAlternately {
    public static void main(String[] args) {
        String str1 = "abckkk";
        String str2 = "pqr";
        System.out.println(mergeAlternately(str1, str2));
    }

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int length1 = word1.length();
        int length2 = word2.length();
        for (int i = 0; i < length1 || i < length2; i++) {
            if (i < length1) {
                result.append(word1.charAt(i));
            }
            if (i < length2) {
                result.append(word2.charAt(i));
            }
        }
        return result.toString();
    }
}
