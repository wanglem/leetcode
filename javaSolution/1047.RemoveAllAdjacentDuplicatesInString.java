
import java.util.Stack;

// BB
class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String S) {
        Stack<Character> st = new Stack<>();
        for (char c: S.toCharArray()) {
            if (st.isEmpty() || st.peek() != c) {
                st.push(c);
            } else {
                st.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c: st) {
            sb.append(c);
        }
        return sb.toString();
    }
}