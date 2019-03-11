class LCATree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    class LCAState {
        boolean findP = false;
        boolean findQ = false;
        TreeNode lca = null;
        boolean found() {
            return findP && findQ;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findLCA(root, p, q).lca;
    }

    private LCAState findLCA(TreeNode root, TreeNode p, TreeNode q) {
        LCAState state = new LCAState();
        if (root == null) return state;
        if (root.val == p.val){
            state.findP = true;
        } else if (root.val == q.val) {
            state.findQ = true;
        }

        LCAState leftFound = findLCA(root.left, p, q);
        LCAState rightFound = findLCA(root.right, p, q);
        state.findP = state.findP || leftFound.findP || rightFound.findP;
        state.findQ = state.findQ || leftFound.findQ || rightFound.findQ;
        if (state.found()) {
            if (state.lca == null) {
                state.lca = root;
            }
        }
        return state;
    }
}