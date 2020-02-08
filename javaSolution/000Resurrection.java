import java.util.*;

class Resurrection {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prior = new ListNode(1);
        prior.next = head;
        ListNode left = prior, right = head;
        for (; n > 0; n--) {
            right = right.next;
        }
        while (right != null) {
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return prior.next;
    }
}