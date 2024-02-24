package LearnWithBook.chapter16;

import java.util.HashMap;

public class TestHashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> scores = new HashMap<String, Integer>();

        scores.put("Katty", 42);
        scores.put("Bert", 343);
        scores.put("Skyler", 420);

        System.out.println(scores);
        System.out.println(scores.get("Bert"));
        System.out.println(scores.size());
        System.out.println(scores.keySet());
    }
}
