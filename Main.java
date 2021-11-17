package lesson3.task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
    String [] words = new String[] {
            "pencil",
            "table",
            "pen",
            "tree",
            "bee",
            "mouse",
            "dog",
            "table",
            "lemon",
            "tree",
            "bear",
            "song",
            "pen",
            "photo",
            "name"};
        Map<String, Integer> wordCounter = new HashMap<>();
        for (String word: words) {
            if(wordCounter.containsKey(word)) {
                wordCounter.put(word, wordCounter.get(word) + 1);
            } else {
                wordCounter.put(word, 1);
            }
            System.out.println();
        }
        for (Map.Entry<String, Integer> uniqueWords: wordCounter.entrySet()) {
            System.out.println(uniqueWords.getKey() + " - " + uniqueWords.getValue());
        }
    }
}
