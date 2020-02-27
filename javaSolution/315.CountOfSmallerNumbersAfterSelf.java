import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    G.
    Bottom up, maintain a counting heap using tree structure.
    put smaller/equal values on left, larger ones on right.
        when put on left, currentNodeCount++.
        when put on right, count += currentNodeCount + 1. (+1 for current node)
    Repeat above step and insert all nodes.
 */
class CountOfSmallerNumbersAfterSelf {
    private class TreeNode {
        TreeNode left, right;
        int count = 0;
        int val;
        TreeNode(int v) {
            val = v;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0) return res;
        TreeNode root = new TreeNode(nums[nums.length-1]);
        res.add(0);
        for (int i = nums.length-2; i >= 0; i--) {
            int count = 0;
            TreeNode parent = root;
            TreeNode current = root;
            while(current != null) {
                parent = current;
                if (nums[i] <= current.val) {
                    current.count += 1;
                    current = current.left;
                } else {
                    count += current.count + 1;
                    current = current.right;
                }
            }

            TreeNode newNode = new TreeNode(nums[i]);
            if (nums[i] <= parent.val) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }
            res.add(count);
        }

        Collections.reverse(res);
        return res;
    }
}