class CountGoodNodesinBinaryTree {
    private int nodes;
    public int goodNodes(TreeNode root) {
        nodes = 0;
        countGoodNodes(root, root.val);
        return nodes;
    }

    private void countGoodNodes(TreeNode root, int largest) {
        if (root == null) return;
        if (largest <= root.val) nodes++;
        largest = Math.max(largest, root.val);
        countGoodNodes(root.left, largest);
        countGoodNodes(root.right, largest);
    }
}