
// FB

/**
 * DO not iterate whole tree.
 *
 * Mid TreeNode is the middle of left or right.
 * Either go left or right child depends on target < root.val or target > root.val.
 */
class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        int closest = root.val;
        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(closest - target)) {
                closest = root.val;
            }
            if (target < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return closest;
    }
}