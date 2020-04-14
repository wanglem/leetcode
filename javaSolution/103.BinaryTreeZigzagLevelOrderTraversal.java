import java.util.*;

class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 1;

        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> levelArr = new ArrayList<>();
            while (levelSize-- > 0) {
                TreeNode last = q.poll();
                levelArr.add(last.val);
                if (last.left != null) q.offer(last.left);
                if (last.right != null) q.offer(last.right);
            }
            if (level++ % 2 == 0) Collections.reverse(levelArr);
            res.add(levelArr);
        }
        return res;
    }
}