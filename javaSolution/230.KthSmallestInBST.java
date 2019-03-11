import java.util.Stack;

/**
 * Definition for a binary tree node.

 */
class KthSmallestInBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> buf = new Stack<>();
        while (root != null || !buf.isEmpty()) {
            while (root != null) {
                buf.push(root);
                root = root.left;
            }
            root = buf.pop();
            k--;
            if (k == 0) {
                return root.val;
            }
            root = root.right;
        }
        return -1;
    }

}