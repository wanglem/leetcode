import javafx.util.Pair;

import java.util.*;

/**
 * FB
 * all words have same length.
 * each time replace one letter. find if beginWord -> endWord steps.
 */
class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> regexMatch = new HashMap<>();

        wordList.forEach( word -> {
            for (int i = 0; i < word.length(); i++) {
                String wordKey = word.substring(0, i) + "." + word.substring(i+1);
                regexMatch.putIfAbsent(wordKey, new ArrayList<>());
                regexMatch.get(wordKey).add(word);
            }
        });

        Set<String> visited = new HashSet<>();
        Queue<Pair<String, Integer>> process = new LinkedList<>();
        process.offer(new Pair<>(beginWord, 1));

        while (!process.isEmpty()) {
            Pair<String, Integer> next = process.poll();
            String word = next.getKey();
            Integer step = next.getValue();

            for (int i = 0; i < word.length(); i++) {
                String wordKey = word.substring(0, i) + "." + word.substring(i+1);
                for (String nextWord: regexMatch.getOrDefault(wordKey, new ArrayList<>())) {
                    if (nextWord.equals(endWord)) {
                        return step+1;
                    }

                    if (!visited.contains(nextWord)) {
                        process.offer(new Pair<>(nextWord, step+1));
                        visited.add(nextWord);
                    }
                }
            }
        }

        return 0;
    }
}