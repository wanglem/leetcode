import java.util.*;

class ExpressionAddOperators {
    private Map<Integer, Character> ops = new HashMap<>();

    public List<String> addOperators(String num, int target) {
        if (num.length() == 0) return new ArrayList<>();
        ops.put(-1, '+');
        ops.put(-2, '-');
        ops.put(-3, '*');
        return  tryOperators(num.toCharArray(), target, new ArrayDeque<>(), 0);
    }

    private List<String> tryOperators(char[] num, int target, Deque<Integer> exp, int index) {
        int[] ops = {-1, -2, -3};
        List<String> res = new ArrayList<>();
        for (int i = index; i < num.length; i++) {
            if (num[index] == '0' && i > index) break;
            exp.offer(toNum(num, index, i));
            if (i == num.length - 1) {
                if (evaluate(exp) == target) {
                    res.add(evalToString(exp));
                }
            } else  {
                for (int op : ops) {
                    exp.offer(op);
                    List<String> ans = tryOperators(num, target, exp, i+1);
                    exp.pollLast();
                    res.addAll(ans);
                }
            }
            exp.pollLast();
        }
        return res;
    }
    private int evaluate(Deque<Integer> exp) {
        exp.offerFirst(-1);
        exp.offerFirst(0);
        Iterator<Integer> iter = exp.iterator();
        int eval = iter.next();
        int last = 0;
        boolean lastMultiplied = false;
        while(iter.hasNext()) {
            int op = ops.get(iter.next());
            int nextVal = iter.next();
            switch (op){
                case '+' :
                    eval += nextVal;
                    last = -1*nextVal;
                    lastMultiplied = false;
                    break;
                case '-' :
                    eval -= nextVal;
                    last = nextVal;
                    lastMultiplied = false;
                    break;
                case '*' :
                    if (!lastMultiplied) {
                        eval += last;
                        eval += -1*last*nextVal;
                        last = last*nextVal;
                    } else {
                        eval *= nextVal;
                        last *= nextVal;
                    }
                    lastMultiplied = true;
                    break;
            }
        }
        exp.pollFirst();
        exp.pollFirst();
        return eval;
    }
    private String evalToString(Deque<Integer> exp) {
        StringBuilder sb = new StringBuilder();
        Iterator<Integer> iter = exp.iterator();
        while (iter.hasNext()) {
            int next = iter.next();
            if (next <= 0) {
                sb.append(ops.get(next));
            } else {
                sb.append(next);
            }
        }
        return sb.toString();
    }
    private int toNum(char[] num, int i, int j) {
        int res = 0;
        while (i <= j) {
            res *= 10;
            res += num[i] - '0';
            i++;
        }
        return res;
    }
}