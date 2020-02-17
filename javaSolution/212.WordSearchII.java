import java.util.*;

class WordSearchII {
    private class TrieNode {
        char n;
        boolean isWord;
        TrieNode[] neighbors;

        TrieNode(char c) {
            n = c;
            isWord = false;
            neighbors = new TrieNode[26];
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode('0');
        buildTrie(root, words);
        int m = board.length, n = board[0].length;
        Set<String> res = new HashSet<>();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res.addAll(find(i, j ,board, visited, root, new Stack<>()));
            }
        }
        return new ArrayList<>(res);
    }

    private void buildTrie(TrieNode root, String[] words) {
        for (String w: words) {
            TrieNode cur = root;
            for (char c: w.toCharArray()) {
                if (cur.neighbors[c - 'a'] == null) {
                    cur.neighbors[c - 'a'] = new TrieNode(c);
                }

                cur = cur.neighbors[c - 'a'];
            }

            cur.isWord = true;
        }
    }

    private List<String> find(int i, int j, char[][] board, boolean[][] visited, TrieNode cur, Stack<Character> word) {
        List<String> res = new ArrayList<>();
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return res;
        if (visited[i][j]) return res;
        char boardLetter = board[i][j];
        TrieNode next = cur.neighbors[boardLetter - 'a'];
        if (null == next) return res;
        
        visited[i][j] = true;
        word.push(board[i][j]);
        if (next.isWord) {
            res.add(getWord(word));
        }

        res.addAll(find(i-1, j, board, visited, next, word));
        res.addAll(find(i+1, j, board, visited, next, word));
        res.addAll(find(i, j-1, board, visited, next, word));
        res.addAll(find(i, j+1, board, visited, next, word));
        visited[i][j] = false;
        word.pop();
        return res;
    }

    private String getWord(Stack<Character> word) {
        StringBuilder sb = new StringBuilder();
        for (char c: word) {
            sb.append(c);
        }
        return sb.toString();
    }
}