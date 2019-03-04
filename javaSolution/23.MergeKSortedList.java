import java.util.Arrays;


class MergeKSortedList {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        int mid = lists.length / 2;
        ListNode merged1 = mergeKLists(Arrays.copyOfRange(lists, 0, mid));
        ListNode merged2 = mergeKLists(Arrays.copyOfRange(lists, mid, lists.length));
        return merge2Lists(merged1, merged2);
    }

    private ListNode merge2Lists(ListNode l1, ListNode l2) {
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