
// return both LCA and deepest depth it reaches on that branch
// if left.deepest == right.deepest, this is a LCA of currently found leaves
// or return left/right whoever has larger deepest.
class LowestCommonAncestorOfDeepestLeaves {
    private class DepthTreeNode {
        TreeNode node;
        int deepest;
        DepthTreeNode(TreeNode n, int d) {
            node = n;
            deepest = d;
        }
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return findLCA(root, 0).node;
    }

    private DepthTreeNode findLCA(TreeNode root, int depth) {
        if (root == null) return new DepthTreeNode(null, depth);

        DepthTreeNode left = findLCA(root.left, depth+1);
        DepthTreeNode right = findLCA(root.right, depth+1);

        if (left.deepest == right.deepest) {
            return new DepthTreeNode(root, left.deepest);
        }

        return left.deepest > right.deepest ? left : right;
    }
}