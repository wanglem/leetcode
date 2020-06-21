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

    public Node connectNoSpace(Node root) {
        Node up = root;
        Node down = new Node(0);
        Node downHead = down;
        while (up != null) {
            if (up.left != null) {
                down.next = up.left;
                down = down.next;
            }
            if (up.right != null) {
                down.next = up.right;
                down = down.next;
            }

            up = up.next;
            if (up == null) {
                up = downHead.next;
                down = new Node(0);
                downHead = down;
            }
        }
        return root;
    }
}