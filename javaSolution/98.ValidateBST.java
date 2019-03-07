import java.util.Stack;

class ValidateBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return validateBST(root, null, null);
    }

    private boolean validateBST(TreeNode node, Integer upperLimit, Integer lowerLimit) {
        if (node == null) return true;
        boolean isLeftValid = true;
        if (upperLimit != null && node.val >= upperLimit) {
            return false;
        }
        if (lowerLimit != null && node.val <= lowerLimit) {
            return false;
        }
        isLeftValid = validateBST(node.left, node.val, lowerLimit);
        if (isLeftValid) {
            return validateBST(node.right, upperLimit, node.val);
        } else {
            return false;
        }
    }

    public boolean isValidBSTInOrder(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        Integer lastV = null;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            TreeNode cur = stack.pop();
            if (lastV != null && lastV >= cur.val) {
                return false;
            }
            lastV = cur.val;
            node = cur.right;
        }
        return false;
    }
}