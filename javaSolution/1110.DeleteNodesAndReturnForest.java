import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class DeleteNodesAndReturnForest {
    private List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> toDelete = IntStream.of(to_delete).boxed().collect(Collectors.toSet());
        delete(root, toDelete,true);
        return res;
    }

    private TreeNode delete(TreeNode cur, Set<Integer> del, boolean isRoot) {
        if (cur == null) return null;
        boolean deleted = del.contains(cur.val);
        cur.left = delete(cur.left, del, deleted);
        cur.right = delete(cur.right, del, deleted);

        if (!deleted && isRoot) res.add(cur);
        return deleted ? null : cur;
    }

    private class RootedTreeNode {
        TreeNode n;
        boolean isRoot;
        RootedTreeNode(TreeNode n, boolean isRoot) {
            this.n = n;
            this.isRoot = isRoot;
        }
    }
    public List<TreeNode> del(TreeNode root, int[] to_delete) {
        Set<Integer> toDelete = IntStream.of(to_delete).boxed().collect(Collectors.toSet());
        List<TreeNode> res = new ArrayList<>();
        Queue<RootedTreeNode> Q = new LinkedList<>();
        Q.offer(new RootedTreeNode(root, true));
        while (!Q.isEmpty()) {
            RootedTreeNode last = Q.poll();
            if (last.n == null) continue;
            if (!toDelete.contains(last.n.val) && last.isRoot) {
                res.add(last.n);
            }

            boolean isRoot = toDelete.contains(last.n.val);
            if (last.n.left != null) {
                Q.offer(new RootedTreeNode(last.n.left, isRoot));
                if (toDelete.contains(last.n.left.val)) {
                    last.n.left = null;
                }
            }
            if (last.n.right != null) {
                Q.offer(new RootedTreeNode(last.n.right, isRoot));
                if (toDelete.contains(last.n.right.val)) {
                    last.n.right = null;
                }
            }
        }
        if (toDelete.contains(root.val)) {
            root.left = null;
            root.right = null;
        }
        return res;
    }
}