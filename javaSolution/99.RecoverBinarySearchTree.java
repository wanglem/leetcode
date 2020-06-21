
// MSFT
/*
    Idea: loop through BST in-order traversal, find the non-increasing one.
    Keep a node `previous` for previous of current node.
    One found non-increasing, two cases:
        1. `previous` node is definitely wrong, record it in `one`.
        2. `current` node may or may not wrong, record it in `two` until find the second "definitely" wong one.
 */
// From obsevation, swap two elements in an sorted array, first wrong
// element N[i] is always larger than N[i+1].
class RecoverBinarySearchTree {
    private TreeNode one;
    private TreeNode two;
    private TreeNode previous;
    public void recoverTree(TreeNode root) {
        find(root);
        int tmp = one.val;
        one.val = two.val;
        two.val = tmp;
    }

    private void find(TreeNode root) {
        if (root != null) {
            find(root.left);
            if (previous != null && previous.val > root.val) {
                if (one == null) one = previous;
                two = root;
            }
            previous = root;
            find(root.right);
        }
    }
}