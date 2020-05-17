import java.util.LinkedList;
import java.util.Queue;

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
        level.offer(null);
        while (!level.isEmpty()) {
            Node left = level.poll();
            if (left.left != null) level.offer(left.left);
            if (left.right != null) level.offer(left.right);
            left.next = level.peek();

            if (level.peek() == null) {
                level.poll();
                if (level.size() > 0) level.offer(null);
            }
        }
        return root;
    }
}