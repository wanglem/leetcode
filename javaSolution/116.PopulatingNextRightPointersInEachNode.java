import java.util.LinkedList;
import java.util.Queue;

class PopulatingNextRightPointersInEachNode {
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
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);

        while (!q.isEmpty()) {
            Node last = q.poll();
            if (null == last) {
                continue;
            }
            if (null != last.left) q.offer(last.left);
            if (null != last.right) q.offer(last.right);
            if (q.peek() != null) {
                last.next = q.peek();
            } else {
                q.offer(null);
            }
        }

        return root;
    }
}