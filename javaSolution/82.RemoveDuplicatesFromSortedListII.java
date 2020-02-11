class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode pre = fakeHead;
        while (head != null) {
            boolean dup = false;
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
                dup = true;
            }
            if (dup) pre.next = head.next;
            else pre = pre.next;
            head = head.next;
        }
        return fakeHead.next;
    }
}