class FlattenAMultilevelDoublyLinkedList{
    private class Node {
        int val;
        Node prev;
        Node next;
        Node child;
    }

    public Node flatten(Node head) {
        flattenLevel(head);
        return head;
    }

    private Node[] flattenLevel(Node head) {
        if (head == null) return null;
        Node fakeHead = new Node();
        fakeHead.next = head;

        // going backwards
        while (head.next != null) head = head.next;
        Node tail = head;

        while (head != null) {
            if (head.child != null) {
                Node[] childLevel = flattenLevel(head.child);
                Node headNext = head.next;
                head.next = childLevel[0];
                childLevel[0].prev = head;
                if (headNext != null) {
                    childLevel[1].next = headNext;
                    headNext.prev = childLevel[1];
                }
                head.child = null;
            }
            head = head.prev;
        }
        return new Node[]{fakeHead.next, tail};
    }
}