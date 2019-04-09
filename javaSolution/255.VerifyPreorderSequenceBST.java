import java.util.Stack;

// Verify preorder in array as BST
//              5
//             / \
//            2   6
//           / \
//          1   3
// -> [5,2,1,3,6]
class VerifyPreorderSequenceBST {

    public boolean verifyPreorder(int[] preorder) {
        int localRoot = Integer.MIN_VALUE;
        Stack<Integer> traverse = new Stack<>();
        for (int pre : preorder) {
            if (pre < localRoot) return false;
            while (!traverse.isEmpty() && pre > traverse.peek()) {
                localRoot = traverse.pop();
            }
            traverse.push(pre);
        }
        return true;
    }
}