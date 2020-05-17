class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        return convert(head, length(head));
    }

    private TreeNode convert(ListNode head, int length) {
        if (length == 0) return null;
        if (length == 1) return new TreeNode(head.val);

        int mid = length / 2;
        ListNode parentNode = head;
        for (int i = 0; i < mid; i ++) {
            parentNode = parentNode.next;
        }
        TreeNode parent = new TreeNode(parentNode.val);
        ListNode rightStart = parentNode.next;

        parent.left = convert(head, mid);
        parent.right = convert(rightStart, length - mid - 1);

        return parent;
    }

    private int length(ListNode head) {
        int l = 0;
        while (head != null) {
            l++;
            head = head.next;
        }
        return l;
    }

}