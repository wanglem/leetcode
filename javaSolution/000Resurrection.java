import java.util.*;

class Resurrection {

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> inorder = new Stack<>();
        TreeNode prev = null;
        while (!inorder.isEmpty() || root != null) {
            while (root != null) {
                inorder.push(root);
                root = root.left;
            }
            root = inorder.pop();
            if (prev != null && prev.val >= root.val) {
                return false;
            }
            prev = root;
            root = root.right;
        }

        return true;
    }
}
