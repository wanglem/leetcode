import java.util.Stack;

class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode node = null;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int v = carry;
            if (!s1.isEmpty()) {
                v += s1.pop().val;
            }
            if (!s2.isEmpty()) {
                v += s2.pop().val;
            }

            ListNode head = new ListNode(v%10);
            carry = v/10;
            head.next = node;
            node = head;
        }
        if (carry == 1) {
            ListNode head = new ListNode(1);
            head.next = node;
            node = head;
        }

        return node;
    }
}