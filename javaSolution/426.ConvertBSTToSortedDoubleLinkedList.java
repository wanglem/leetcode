import java.util.Stack;

class ConvertBSTToSortedDoubleLinkedList {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node() {}
        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        Node head = new Node();
        Node start = null;
        Stack<Node> inorder = new Stack<>();
        while (root != null || !inorder.isEmpty()) {
            while (root != null) {
                inorder.push(root);
                root = root.left;
            }
            root = inorder.pop();
            if (start == null) {
                start = root;
                head.right = start;
            } else {
                start.right = root;
                root.left = start;
                start = start.right;
            }
            if (root.right == null && inorder.isEmpty()) {
                head.right.left = root;
                root.right = head.right;
                break;
            }
            root = root.right;
        }
        return head.right;
    }
}