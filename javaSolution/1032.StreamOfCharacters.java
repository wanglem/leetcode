
import java.util.*;

class StreamOfCharacters {

    private class TrieNode {
        boolean word;
        TrieNode[] next;
        TrieNode() {
            next = new TrieNode[26];
            word = false;
        }
    }

    private TrieNode root;
    private List<TrieNode> pts;
    public StreamOfCharacters(String[] words) {
        root = new TrieNode();
        pts = new ArrayList<>();
        for (String w: words) insert(w);
    }

    private void insert(String str) {
        TrieNode cur = root;
        for (char c: str.toCharArray()) {
            if (cur.next[c - 'a'] == null) cur.next[c-'a'] = new TrieNode();
            cur = cur.next[c - 'a'];
        }
        cur.word = true;
    }

    public boolean query(char letter) {
        List<TrieNode> remove = new ArrayList<>();
        boolean found = false;
        pts.add(root);
        for (int i = 0; i < pts.size(); i++) {
            TrieNode node = pts.get(i);
            if (node.next[letter - 'a'] != null) {
                if (node.next[letter - 'a'].word) {
                    found = true;
                }
                pts.set(i, node.next[letter - 'a']);
            } else {
                remove.add(node);
            }
        }
        pts.removeAll(remove);
        return found;
    }
}