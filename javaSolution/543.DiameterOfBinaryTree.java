import java.util.Arrays;
import java.util.Collections;

// fb, google
// longest path between any two nodes
class DiameterOfBinaryTree {
    private int longest = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        findLongestDiameter(root);
        return longest;
    }

    // int longest branch from current node to children
    private int findLongestDiameter(TreeNode root) {
        if (root == null) return 0;

        int leftLongest = findLongestDiameter(root.left);
        int rightLongest = findLongestDiameter(root.right);
        longest = Math.max(longest, leftLongest + rightLongest);
        return Math.max(leftLongest, rightLongest) + 1;
    }
}