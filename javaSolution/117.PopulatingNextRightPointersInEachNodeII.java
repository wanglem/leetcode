import java.util.LinkedList;
import java.util.Queue;

// BB
class PopulatingNextRightPointersInEachNodeII {
    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> level = new LinkedList<>();
        level.offer(root);
        while (!level.isEmpty()) {
            int size = level.size();
            while (size-- > 0) {
                Node left = level.poll();
                if (size > 0) left.next = level.peek();
                if (left.left != null) level.offer(left.left);
                if (left.right != null) level.offer(left.right);
            }

        }
        return root;
    }
}