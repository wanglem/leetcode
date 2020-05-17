import java.util.*;
import java.util.stream.Collectors;

class VerticalOrderTraversalBinaryTree {
    private class IndexedNode {
        TreeNode r;
        int vertical;
        int horizontal;
        IndexedNode(TreeNode n, int i, int j) {
            r = n;
            vertical = i;
            horizontal = j;
        }
    }
    private class LeveledNode {
        int level;
        int val;
        LeveledNode (int l, int v) {
            level = l;
            val = v;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<IndexedNode> Q = new LinkedList<>();
        Q.offer(new IndexedNode(root, 0, 0));
        TreeMap<Integer, List<LeveledNode>> bucket = new TreeMap<>();

        while (!Q.isEmpty()) {
            IndexedNode n = Q.poll();
            if (n.r.left != null) {
                Q.offer(new IndexedNode(n.r.left, n.vertical - 1, n.horizontal + 1));
            }
            if (n.r.right != null) {
                Q.offer(new IndexedNode(n.r.right, n.vertical + 1, n.horizontal + 1));
            }

            bucket.computeIfAbsent(n.vertical, k -> new ArrayList<>());
            bucket.get(n.vertical).add(new LeveledNode(n.horizontal, n.r.val));
        }

        bucket.values().forEach(li -> li.sort((x, y) -> {
            if (x.level == y.level) {
                return Integer.compare(x.val, y.val);
            }
            return Integer.compare(x.level, y.level);
        }));

        List<List<Integer>> res = new ArrayList<>();
        for (List<LeveledNode> ln: bucket.values()) {
            res.add(ln.stream().map(x -> x.val).collect(Collectors.toList()));
        }
        return res;
    }
}