import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// return each level of binary tree as a list
class BinaryTreeOrderLevelTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        queue.offer(root);
        queue.offer(null);
        while (!queue.isEmpty()) {
            LinkedList<Integer> curLevel = new LinkedList<>();
            while(!queue.isEmpty()) {
                TreeNode curNode = queue.poll();
                if (curNode == null) {
                    break;
                }
                curLevel.add(curNode.val);
                if (curNode.left != null) queue.offer(curNode.left);
                if (curNode.right != null) queue.offer(curNode.right);
            }
            if (!queue.isEmpty()) queue.offer(null);
            res.add(curLevel);
        }
        return res;
    }
}