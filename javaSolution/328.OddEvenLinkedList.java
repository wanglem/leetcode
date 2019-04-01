/**

 */
class OddEvenLinkedList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);
        ListNode oddI = odd;
        ListNode evenI = even;
        boolean isEven = false;
        while (head != null) {
            if (isEven) {
                evenI.next = head;
                evenI = evenI.next;
            } else {
                oddI.next = head;
                oddI = oddI.next;
            }
            isEven = !isEven;
            head = head.next;
        }
        oddI.next = even.next;
        return odd.next;
    }
}