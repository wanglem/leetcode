import java.util.ArrayList;
import java.util.List;

// FB
// bottom up, return distance to target node, -1 is not found
// if from target from leftChild, count right with relative distance. Vice versa.
class AllNodesDistanceKInBinaryTree {
    private int K;
    private List<Integer> res;
    private TreeNode target;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        this.K = K;
        res = new ArrayList<>();
        this.target = target;
        searchTarget(root);
        return res;
    }

    private int searchTarget(TreeNode cur) {
        if (cur == null) return -1;

        if (cur == target) {
            add(cur, 0);
            return 1;
        }

        int left = searchTarget(cur.left);
        int right = searchTarget(cur.right);

        if (left > 0) {
            if (left == K) res.add(cur.val);
            add(cur.right, left + 1);
            return left + 1;
        }

        if (right > 0) {
            if (right == K) res.add(cur.val);
            add(cur.left, right + 1);
            return right + 1;
        }

        return -1;
    }

    private void add(TreeNode node, int dist) {
        if (node == null) return;
        if (dist == K) {
            res.add(node.val);
        }

        if (dist > K) return;

        add(node.left, dist + 1);
        add(node.right, dist + 1);
    }
}