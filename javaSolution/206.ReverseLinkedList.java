class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode root = new ListNode(0);
        while (head != null) {
            ListNode tmp = head;
            head = head.next;
            tmp.next = root.next;
            root.next = tmp;
        }
        return root.next;
    }
}