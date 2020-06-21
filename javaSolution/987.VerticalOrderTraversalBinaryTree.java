import java.util.*;
import java.util.stream.Collectors;

// FB
class VerticalOrderTraversalBinaryTree {
    private TreeMap<Integer, PriorityQueue<int[]>> bucket = new TreeMap<>();
    public List<List<Integer>> verticalTraversal2(TreeNode root) {
        helper(root, 0, 0);
        List<List<Integer>> res = new ArrayList<>();

        for (Map.Entry<Integer, PriorityQueue<int[]>> e: bucket.entrySet()) {
            List<Integer> line = new ArrayList<>();
            PriorityQueue<int[]> pq = e.getValue();
            while (!pq.isEmpty()) line.add(pq.poll()[1]);
            res.add(line);
        }

        return res;
    }

    private void helper(TreeNode root, int x, int y) {
        if (root == null) return;
        bucket.putIfAbsent(y,  new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(b[0], a[0]);
            return Integer.compare(a[1], b[1]);
        }));
        bucket.get(y).offer(new int[]{x, root.val});
        helper(root.left, x-1, y-1);
        helper(root.right, x-1, y+1);
    }
    
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