class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head, end = head;
        ListNode fakeHead = new ListNode(0);
        ListNode tail = fakeHead;
        int m = 1;
        while (end != null) {
            end = end.next;
            m++;
            if (m == k && end != null) {
                ListNode tmp = end;
                end = end.next;
                tmp.next = null;
                tail.next = reverse(start);
                m = 1;
                while (tail.next != null) tail = tail.next;
                start = end;
            }
        }

        if (m != 1) tail.next = start;
        return fakeHead.next;
    }

    private ListNode reverse(ListNode n) {
        ListNode head = new ListNode(1);
        while (n != null) {
            ListNode insert = n;
            n = n.next;
            ListNode prev = head.next;
            head.next = insert;
            insert.next = prev;
        }
        return head.next;
    }
}