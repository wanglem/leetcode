// FB
// max path sum from any node to another node, no need to pass root
class BinaryTreeMaxPathSum {
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        traverse(root);
        return maxSum;
    }

    private int traverse(TreeNode root) {
        if (root == null) return 0;

        int leftSum = Math.max(0, traverse(root.left));
        int rightSum = Math.max(0, traverse(root.right));

        maxSum = Math.max(leftSum + root.val + rightSum, maxSum);

        return root.val + Math.max(leftSum, rightSum);
    }
}