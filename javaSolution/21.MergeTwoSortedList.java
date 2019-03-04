
class MergeTwoSortedList {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode mergedHead = new ListNode(0);
        ListNode toMerge = mergedHead;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                toMerge.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                toMerge.next = l1;
                l1 = l1.next;
            } else if(l1.val <= l2.val) {
                toMerge.next = l1;
                l1 = l1.next;
            } else {
                toMerge.next = l2;
                l2 = l2.next;
            }
            toMerge = toMerge.next;
        }
        return mergedHead.next;
    }
}