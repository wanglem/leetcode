class MaximumDifferenceBetweenNodeAndAncestor {

    private int maxGap = Integer.MIN_VALUE;
    private int smallestGap = Integer.MAX_VALUE;
    public int maxAncestorDiff(TreeNode root) {
        findMaxGap(root, root.val, root.val);
        return Math.max(Math.abs(maxGap), Math.abs(smallestGap));
    }

    private void findMaxGap(TreeNode root, int maxAncestor, int leastAncestor) {
        if (root == null) return;
        maxGap = Math.max(maxAncestor - root.val, maxGap);
        smallestGap = Math.min(leastAncestor - root.val, smallestGap);

        findMaxGap(root.left, Math.max(maxAncestor, root.val), Math.min(leastAncestor, root.val));
        findMaxGap(root.right, Math.max(maxAncestor, root.val), Math.min(leastAncestor, root.val));
    }
}