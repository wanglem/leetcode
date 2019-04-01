import java.util.*;

/*
    recursion two parameters:
        1. vertical index for TreeMap grouping
        2. tree index of current node
 */
class BinaryTreeVerticalOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    private class IndexedNode {
        TreeNode node;
        int index;
        IndexedNode(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return new ArrayList<>();
        TreeMap<Integer, List<IndexedNode>> verticalIndexed = traverse(root, 1, 0);
        for (Map.Entry<Integer, List<IndexedNode>> e : verticalIndexed.entrySet()) {
            List<Integer> vertical = new ArrayList<>();
            Collections.sort(e.getValue(), (x, y) -> x.index - y.index);
            for (IndexedNode n : e.getValue()) {
                vertical.add(n.node.val);
            }
            res.add(vertical);
        }
        return res;
    }

    private TreeMap<Integer, List<IndexedNode>> traverse(TreeNode n, int index, int vertical) {
        TreeMap<Integer, List<IndexedNode>> res = new TreeMap<>();
        if (n == null) return res;
        res.put(vertical, new ArrayList<>());
        res.get(vertical).add(new IndexedNode(n, index));
        TreeMap<Integer, List<IndexedNode>> left = traverse(n.left, 2*index-1, vertical-1);
        TreeMap<Integer, List<IndexedNode>> right = traverse(n.right, 2*index+1, vertical+1);
        return merge(res, merge(left, right));
    }

    private TreeMap<Integer, List<IndexedNode>> merge(TreeMap<Integer, List<IndexedNode>> left, TreeMap<Integer, List<IndexedNode>> right) {
        for (Map.Entry<Integer, List<IndexedNode>> e : right.entrySet()) {
            List<IndexedNode> v = left.getOrDefault(e.getKey(), new ArrayList<>());
            v.addAll(e.getValue());
            left.put(e.getKey(), e.getValue());
        }
        return left;
    }
}