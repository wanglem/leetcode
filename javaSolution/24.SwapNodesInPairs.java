class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode left = fakeHead, right = head;
        while (right != null) {
            for (int i = 0; i < 2; i++) {
                if (right == null) return fakeHead.next;
                right = right.next;
            }
            swapTwo(left, right);
            left = left.next.next;
        }
        return fakeHead.next;
    }

    private void swapTwo(ListNode l1, ListNode l2) {
        ListNode a = l1.next;
        ListNode b = l1.next.next;
        l1.next = b;
        b.next = a;
        a.next = l2;
    }
}