import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class ValidParentheses {
    public boolean isValid(String s) {
        HashMap<Character, Character> parenMap = new HashMap<>();
        parenMap.put('}', '{');
        parenMap.put(']', '[');
        parenMap.put(')', '(');
        Set<Character> opens = new HashSet<>(parenMap.values());
        Stack<Character> stackBuffer = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (opens.contains(cur)) {
                stackBuffer.push(cur);
            } else if (stackBuffer.isEmpty() || stackBuffer.pop() != parenMap.get(cur)) {
                return false;
            }
        }
        return stackBuffer.isEmpty();
    }
}