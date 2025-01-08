package PracticeTasks;

public class LC3042_countPrefixSuffixPairs {
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) count++;
            }
        }
        return count;
    }

    private boolean isPrefixAndSuffix(String prefixAndSuffix, String word) {
        return word.startsWith(prefixAndSuffix)
                && word.endsWith(prefixAndSuffix);
    }

    public static void main(String[] args) {
        String[] words = {"pa", "papa", "ma", "mama"};
        System.out.println(new LC3042_countPrefixSuffixPairs().countPrefixSuffixPairs(words));
    }
}
