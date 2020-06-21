import java.util.Stack;

class BasicCalculatorII {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();

        char[] ss = s.toCharArray();
        int num = 0;
        char lastSign = '+';
        for (int i = 0; i < ss.length; i++) {
            char c = ss[i];
            if (c >= '0' && c <= '9') {
                num *= 10;
                num += c - '0';
            }
            if (i == ss.length - 1 || c != ' ' && (c < '0' || c > '9')) {
                if (lastSign == '+') {
                    st.push(num);
                } else if (lastSign == '-') {
                    st.push(-num);
                } else if (lastSign == '*') {
                    st.push(st.pop()*num);
                } else if (lastSign == '/'){
                    st.push(st.pop()/num);
                }

                lastSign = c;
                num = 0;
            }
        }
        int res = 0;
        for (int x: st) res += x;
        return res;
    }
}