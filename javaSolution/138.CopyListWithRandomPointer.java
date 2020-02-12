import java.util.HashMap;
import java.util.Map;

/*
A linked list is given such that each node contains an additional random pointer
which could point to any node in the list or null.

Return a deep copy of the list.

The Linked List is represented in the input/output as a list of n nodes. Each
node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) where random pointer
points to, or null if it does not point to any node.
 
 */
class CopyListWithRandomPointer {

    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Node> originToCopy = new HashMap<>();
        Node origin = head;
        Node copyPior = new Node(0);
        Node copy = copyPior;
        while (origin != null) {
            Node copyNode = new Node(origin.val);
            originToCopy.put(origin, copyNode);
            copy.next = copyNode;
            copy = copy.next;
            origin = origin.next;
        }
        origin = head;
        copy = copyPior.next;
        while (origin != null) {
            if (origin.random != null) {
                copy.random = originToCopy.get(origin.random);
            }
            origin = origin.next;
            copy = copy.next;
        }

        return copyPior.next;
    }
}