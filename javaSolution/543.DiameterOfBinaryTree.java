import java.util.Arrays;
import java.util.Collections;

// fb, google
// longest path between any two nodes
class DiameterOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int[] result = findLongestDiameter(root);
        return result[0];
    }

    // int[0] longest diameter so far, int[1] longest branch - either left or right
    private int[] findLongestDiameter(TreeNode root) {
        if (root == null) return new int[]{0, 0};

        int[] left = findLongestDiameter(root.left);
        int[] right = findLongestDiameter(root.right);
        int longestDiameter = Collections.max(Arrays.asList(left[0], right[0], left[1] + right[1] + 1));
        return new int[]{longestDiameter, Math.max(left[0]+1, right[0]+1)};
    }
}