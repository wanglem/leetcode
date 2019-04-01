
/*
    1. Build letter to letter order for all letters we know.
        precedence[i][j] == true means i is before j
    2. for each letter `a` - `z`, dfs/bfs precedence[][] array to build order.
    3. keep visited to prevent revisiting.
    4. if see visiting nodes while searching, return false (cycle found!).
 */
class AlienDictionary {
    private int N = 26;
    /*
        mark:
        0 - not exist
        1 - exist
        2 - visiting
        3 - visited
     */
    public String alienOrder(String[] words) {
        int[] mark = new int[N];
        boolean[][] precedence = buildOrder(words, mark);

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (mark[i] == 1 && !sort(precedence, mark, i, res)) {
                return "";
            }
        }
        return res.reverse().toString();
    }

    private boolean sort(boolean[][] precedence, int[] mark, int cindex, StringBuilder res) {
        mark[cindex] = 2;
        for (int i = 0; i < N; i++) {
            if (mark[i] == 2) return false;
            if (mark[i] != 1) continue;
            if (precedence[cindex][i]) {
                if (!sort(precedence, mark, i, res)) {
                    return false;
                }
            }
        }
        res.append((char)(cindex + 'a'));
        mark[cindex] = 3;
        return true;
    }

    private boolean[][] buildOrder(String[] words, int[] mark) {
        boolean[][] precedence = new boolean[N][N];
        for (int i = 0; i < words.length; i++){
            String w = words[i];
            for (int j = 0; j <w.length(); j++) {
                mark[w.charAt(j) - 'a'] = 1;
            }
            if (i == 0) continue;
            String pre = words[i-1];
            int size = Math.min(w.length(), pre.length());
            for (int j = 0; j < size; j++) {
                if (pre.charAt(j) != w.charAt(j)) {
                    precedence[pre.charAt(j) - 'a'][w.charAt(j) - 'a'] = true;
                    break;
                }
            }
        }
        return precedence;
    }
}