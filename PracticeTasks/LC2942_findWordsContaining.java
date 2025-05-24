package PracticeTasks;

import java.util.ArrayList;
import java.util.List;

public class LC2942_findWordsContaining {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(x) != -1) result.add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        String[] words = {"abc", "bcd", "aaaa", "cbc"};
        System.out.println(new LC2942_findWordsContaining().findWordsContaining(words, 'a'));
    }
}
