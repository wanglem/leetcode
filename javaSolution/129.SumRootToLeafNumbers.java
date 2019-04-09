import java.util.List;

// each path from root -> leaf is integer, sum up all paths
// top-down approach
class SumRootToLeafNumbers {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int sumNumbers(TreeNode root) {
       return sumNumbers(root, 0);
    }
    private int sumNumbers(TreeNode root, int pathNum) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return pathNum*10 + root.val;
        }
        return sumNumbers(root.left, 10*pathNum + root.val) + sumNumbers(root.right, 10*pathNum + root.val);
    }
}