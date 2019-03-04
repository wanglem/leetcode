class Solution {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode toDeletePrev = new ListNode(0);
        toDeletePrev.next = head;
        ListNode offsetNode = head;
        ListNode preHead = toDeletePrev;
        while (offsetNode != null) {
            // delete Nth node we want the pointer to be at N-1 node
            if (n == 0) {
                toDeletePrev = toDeletePrev.next;
            } else {
                n--;
            }
            offsetNode = offsetNode.next;
        }
        toDeletePrev.next = toDeletePrev.next.next;
        return preHead.next;
    }
}