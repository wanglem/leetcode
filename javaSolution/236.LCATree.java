class LCATree {
    private TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findLCA(root, p, q);
        return lca;
    }

    private int findLCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return 0;

        int status = 0;
        int leftFound = findLCA(root.left, p, q);
        if (leftFound == 2) return 2;
        int rightFound = findLCA(root.right, p, q);
        if (rightFound == 2) return 2;
        if (root.val == p.val) status++;
        if (root.val == q.val) status++;
        status += leftFound;
        status += rightFound;
        if (status == 2) {
            lca = root;
        }
        return status;
    }
}