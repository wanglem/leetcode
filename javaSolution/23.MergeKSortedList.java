import java.util.Arrays;


// BB, FB
class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {
        return mergeK(lists, 0, lists.length-1);
    }

    public ListNode mergeKListsStreamAPI(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode minHead = new ListNode(Integer.MIN_VALUE);
        return Arrays.stream(lists).reduce(minHead, (l1, l2) -> merge2Lists(l1, l2)).next;
    }

    public ListNode mergeK(ListNode[] lists, int start, int end) {
        if (start > end) return null;
        if (start == end) return lists[start];
        int mid = (end - start) / 2 + start;
        ListNode merged1 = mergeK(lists, start, mid);
        ListNode merged2 = mergeK(lists, mid+1, end);
        return merge2Lists(merged1, merged2);
    }

    private ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode mergedHead = new ListNode(0);
        ListNode toMerge = mergedHead;
        while (l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                toMerge.next = l1;
                l1 = l1.next;
            } else {
                toMerge.next = l2;
                l2 = l2.next;
            }
            toMerge = toMerge.next;
        }
        if (l1 != null) toMerge.next = l1;
        if (l2 != null) toMerge.next = l2;
        return mergedHead.next;
    }
}