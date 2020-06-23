import java.util.*;


// try out possible of +, -, * of all numbers in num to get target.
class ExpressionAddOperators {

    private List<String> valid;

    public List<String> addOperators(String num, int target) {
        valid = new ArrayList<>();
        if (num.length() == 0) return valid;
        tryOut(0, num, target, 0, 0, 0, new Stack<>());

        return valid;
    }

    /**
     * @param expNum   calculated number
     * @param prevNum  previous number (after + or -)
     * @param curNum   multiple chars combined number
     * @param ops      sign and chars sequences
     */
    private void tryOut(int index, String num, int target, long expNum, long prevNum, long curNum, Stack<String> ops) {
        if (num.length() == index) {
            if (expNum == target && curNum == 0)
                pushResult(ops);
            return;
        }

        int digit = Character.getNumericValue(num.charAt(index));
        if (curNum > 0 || digit > 0) {
            tryOut(index + 1, num, target, expNum, prevNum, curNum * 10 + digit, ops);
        }

        // try plus
        ops.push("+");
        ops.push(Long.toString(curNum));
        tryOut(index+1, num, target, expNum + curNum, curNum, 0, ops);
        ops.pop();
        ops.pop();


        if (ops.size() > 0) {
            // try minus
            ops.push("-");
            ops.push(Long.toString(curNum));
            tryOut(index+1, num, target, expNum - curNum, -curNum, 0, ops);
            ops.pop();
            ops.pop();


            // try minus
            ops.push("*");
            ops.push(Long.toString(curNum));
            tryOut(index+1, num, target, expNum - prevNum + (prevNum * digit), prevNum*digit, 0, ops);
            ops.pop();
            ops.pop();
        }
    }

    private void pushResult(Stack<String> ops) {
        StringBuilder sb = new StringBuilder();
        for (String s: ops) {
            sb.append(s);
        }
        valid.add(sb.toString());
    }
}