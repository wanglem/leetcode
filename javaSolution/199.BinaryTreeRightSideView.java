import java.util.*;

// FB
class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSide = new ArrayList<>();
        if (root == null) {
            return rightSide;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                if (i == 0) {
                    rightSide.add(cur.val);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
            }
        }
        return rightSide;
    }


    // O1 Space, DFS
    // right first, then left
    public List<Integer> rightSideViewDFS(TreeNode root) {
        List<Integer> rightSide = new ArrayList<>();
        dfs(root, rightSide, 0);
        return rightSide;
    }
    private void dfs(TreeNode root, List<Integer> rightSide, int depth) {
        if (root == null) return;

        if (depth == rightSide.size()) {
            rightSide.add(root.val);
        }

        dfs(root.right, rightSide, depth+1);
        dfs(root.left, rightSide, depth+1);
    }
}