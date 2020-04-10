import java.util.*;

class MaximumLengthOfConcatenatedStringwithUniqueCharacters {
    public int maxLength(List<String> arr) {
        List<boolean[]> hashed = new ArrayList<>();
        for (String str: arr) {
            boolean[] sigArr = new boolean[26];
            if (signature(str, sigArr)) {
                hashed.add(sigArr);
            }
        }
        return search(new boolean[26], hashed, 0);
    }

    private int search(boolean[] marked, List<boolean[]> hashed, int start) {
        int maxLength = length(marked);
        for (int i = start; i < hashed.size(); i++) {
            if (update(marked, hashed.get(i))) {
                maxLength = Math.max(maxLength, search(marked, hashed, i+1));
                remove(marked, hashed.get(i));
            }
        }

        return maxLength;
    }

    private int length(boolean[] marked) {
        int l = 0;
        for (boolean m: marked) {
            if (m) l++;
        }
        return l;
    }

    private boolean update(boolean[] base, boolean[] overlay) {
        for (int i = 0; i < base.length; i++) {
            if (base[i] && overlay[i]) return false;
        }
        for (int i = 0; i < base.length; i++) {
            if (overlay[i]) base[i] = true;
        }
        return true;
    }

    private void remove(boolean[] base, boolean[] overlay) {
        for (int i = 0; i < base.length; i++) {
            if (overlay[i]) base[i] = false;
        }
    }

    private boolean signature(String str, boolean[] sigArr) {
        for (char c: str.toCharArray()) {
            if (sigArr[idx(c)]) return false;
            sigArr[idx(c)] = true;
        }

        return true;
    }

    private int idx(char c) {
        return c - 'a';
    }
}