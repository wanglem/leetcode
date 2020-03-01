import java.util.*;
class DesignSearchAutocompleteSystem {
    private class TrieNode {
        String val;
        boolean word;
        int hot;
        TrieNode[] next;
        TrieNode(String c) {
            val = c;
            next = new TrieNode[27];
            word = false;
            hot = 0;
        }
        TrieNode next(char c) {
            return next[indexOf(c)];
        }
        TrieNode set(char c) {
            int idx = indexOf(c);
            next[idx] = new TrieNode(val + c);
            return next[idx];
        }
        private int indexOf(char c) {
            if (c == ' ') return 26;
            return c - 'a';
        }
    }

    private class Trie {
        TrieNode root = new TrieNode("");
        private String cur = "";

        void insert(String str, int times) {
            TrieNode cur = root;
            for (char c: str.toCharArray()) {
                if (cur.next(c) != null) cur = cur.next(c);
                else cur = cur.set(c);
            }
            cur.word = true;
            cur.hot += times;
        }

        List<TrieNode> find(char c) {
            cur += c;
            return prefixOf(cur, 0, root);
        }

        List<TrieNode> prefixOf(String str, int i, TrieNode t) {
            List<TrieNode> res = new ArrayList<>();
            if (i == str.length()) return allWords(t);
            char c = str.charAt(i);
            if (t.next(c) == null) return res;
            return prefixOf(str, i+1, t.next(c));
        }

        List<TrieNode> allWords(TrieNode start) {
            List<TrieNode> res = new ArrayList<>();
            if (start.word) res.add(start);
            for (TrieNode child: start.next) {
                if (child != null) {
                    res.addAll(allWords(child));
                }
            }
            return res;
        }

        void commit() {
            insert(cur, 1);
            cur = "";
        }

    }
    private Trie t = new Trie();

    public DesignSearchAutocompleteSystem(String[] sentences, int[] times) {
        for (int i = 0; i < sentences.length; i++) {
            t.insert(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        List<String> res = new ArrayList<>();
        if (c == '#') {
            t.commit();
            return res;
        }
        List<TrieNode> list = t.find(c);
        Collections.sort(list,
                (a, b) -> a.hot == b.hot ? a.val.compareTo(b.val) : Integer.compare(b.hot, a.hot));
        for (int i = 0; i < Math.min(3, list.size()); i++) {
            res.add(list.get(i).val);
        }
        return res;
    }
}