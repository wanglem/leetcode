import java.util.Stack;

/*
    G.
    Regular DFS and calculate.
 */
class TwentyFourGame {
    public boolean judgePoint24(int[] nums) {
        double[] D = new double[nums.length];
        for (int i=0; i < nums.length; i++)  {
            D[i] = (double) nums[i];
        }

        return search(D, 0, new char[]{'+', '-', '*', '/'}, 0, new Stack<>());
    }

    private boolean search(double[] D, int di, char[] ops, double val, Stack<Character> st) {
        if (di == D.length) {
            return approx24(val);
        }

        for (int i = di; i < D.length; i++) {
            if (i != di && Double.compare(D[i], D[di]) == 0) continue;
            swap(D, i, di);
            for (char op: ops) {
                double curVal = D[di];
                if (di != 0) curVal = calc(op, val, curVal);
                st.push(op);
                boolean found = search(D, di+1, ops, curVal, st);
                st.pop();
                if (found) return true;
            }
            swap(D, i, di);
        }
        return false;
    }

    private void swap(double[] D, int i, int j) {
        double tmp = D[i];
        D[i] = D[j];
        D[j] = tmp;
    }

    private double calc(char op, double x, double y) {
        switch(op) {
            case '+': return x+y;
            case '-': return x-y;
            case '*': return x*y;
            case '/': return x/y;
        }
        throw new RuntimeException("not valid op");
    }

    private boolean approx24(double x) {
        return Math.abs(24.0 - x) < 0.0000001;
    }
}