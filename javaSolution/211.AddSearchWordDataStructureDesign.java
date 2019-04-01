import java.util.HashSet;
import java.util.Set;

class WordDictionarySet {

    private Set<String> store;
    /** Initialize your data structure here. */
    public WordDictionarySet() {
        store = new HashSet<>();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        store.add(word);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return tryWord(word.toCharArray(), 0);
    }
    private boolean tryWord(char[] chars, int index) {
        if (index == chars.length) {
            return testWord(chars);
        }
        for (int i = index; i < chars.length; i++) {
            if (chars[i] == '.') {
                for (int j = 0; j < 26; j++) {
                    chars[i] = (char) ('a' + j);
                    boolean isWord = tryWord(chars, i+1);
                    if (isWord) return true;
                }
                chars[i] = '.';
                return false;
            }
        }
        return testWord(chars);
    }

    private boolean testWord(char[] chars) {
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            sb.append(c);
        }
        return store.contains(sb.toString());
    }
}

class WordDictionaryTrie {
    class TrieNode {
        TrieNode[] charNode = new TrieNode[26];
        Character c;
        boolean isWord = false;
        TrieNode(Character c) {
            this.c = c;
        }
    }
    private TrieNode root;

    public WordDictionaryTrie() {
        root = new TrieNode(null);
    }

    public void addWord(String word) {
        TrieNode head = root;
        for(char c : word.toCharArray()) {
            int index = charToIndex(c);
            if (head.charNode[index] == null) {
                head.charNode[index] = new TrieNode(c);
            }
            head = head.charNode[index];
        }
        head.isWord = true;
    }

    public boolean search(String word) {
        return testWord(word.toCharArray(), 0, root);
    }

    private boolean testWord(char[] word, int index, TrieNode start) {
        if (start == null) return false;
        if (index == word.length) return start.isWord;
        for (int i = index; i < word.length; i++) {
            if (word[i] != '.') {
                return testWord(word, i+1, start.charNode[charToIndex(word[i])]);
            } else {
                for (TrieNode node : start.charNode) {
                    if (node == null) continue;
                    boolean isWord = testWord(word, i+1, node);
                    if (isWord) return true;
                }
                return false;
            }
        }
        return false;
    }

    private int charToIndex(char c) {
        return c - 'a';
    }

}