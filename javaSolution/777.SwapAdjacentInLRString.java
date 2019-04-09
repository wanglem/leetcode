// Google

// XL -> LX, RX -> XR
/*
    Two pointers at start, end.
 */
/*
    c1 in start, c2 in end
    if (c1 == c2) both++;
    if (c1 != c2)
        1. R, L -> false
        2. R, X && R.next != X -> false
        3. L, X && X.next != L -> false
        4. after swap, also check next index equals
 */
class SwapAdjacentInLRString {
    public boolean canTransform(String start, String end) {
        char[] S = start.toCharArray();
        char[] E = end.toCharArray();
        int length = S.length;
        for (int i = 0; i < length-1; i++) {
            if (S[i] != E[i]) {
                if (S[i] == 'X') {
                    char[] tmp = S;
                    S = E;
                    E = tmp;
                }
                if (S[i] == 'R' && E[i] == 'X' && S[i + 1] == 'X') {
                    swapNext(S, i);
                } else if (S[i] == 'L' && E[i] == 'X' && E[i + 1] == 'L') {
                    swapNext(E, i);
                } else {
                    return false;
                }
                if (S[i+1] != E[i+1]) return false;
            }
        }
        return S[length-1] == E[length-1];
    }
    private void swapNext(char[] s, int i) {
        char tmp = s[i];
        s[i] = s[i+1];
        s[i+1] = tmp;
    }
}