// Google
/*
    1. count left most and right most branch. keep counter if their lengths do not match.
    2. when match, we know height of tree, counter is the extra nodes.
    3. height H, full tree nodes are: 2^H - 1.
 */
class CountCompleteTreeNode {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int countNodes(TreeNode root) {
        TreeNode left = root;
        TreeNode right = root;

        int leftCount = 0, rightCount = 0;
        while (left != null) {
            leftCount++;
            left = left.left;
        }
        while (right != null) {
            rightCount++;
            right = right.right;
        }
        if (leftCount == rightCount) {
            return (int)Math.pow(2, leftCount) - 1;
        }
        return 1+countNodes(root.left) + countNodes(root.right);
    }
}