import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// find all root -> leaf paths sum up to `sum`
class PathSumII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        if (root.left == null && root.right == null && root.val == sum) {
            List<Integer> found =  new LinkedList<>();
            found.add(root.val);
            res.add(found);
            return res;
        }
        List<List<Integer>> childAns = pathSum(root.left, sum - root.val);
        childAns.addAll(pathSum(root.right, sum - root.val));
        for(List<Integer> item: childAns) {
            List<Integer> currentFirst = new LinkedList<>();
            currentFirst.add(root.val);
            currentFirst.addAll(item);
            res.add(currentFirst);
        }
        return res;
    }
}