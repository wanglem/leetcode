class PseudoPalindromicPathsinaBinaryTree {

    private int maxPaths = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] count = new int[10];
        traverse(root, count);
        return maxPaths;
    }

    private void traverse(TreeNode root, int[] count) {
        if (root == null) return;
        count[root.val]++;
        if (root.left == null && root.right == null) {
            checkPseudoPal(count);
        }
        traverse(root.left, count);
        traverse(root.right, count);
        count[root.val]--;
    }

    private void checkPseudoPal(int[] count) {
        int odd = 0;
        for (int c: count) {
            if (c % 2 != 0) {
                odd++;
            }
        }

        if (odd <= 1) maxPaths++;
    }
}