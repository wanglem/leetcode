import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * Definition for a binary tree node.

 */
class BSTIterator {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private Deque<Integer> iter = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        Stack<TreeNode> buf = new Stack<>();
        while(root !=  null || !buf.isEmpty()) {
            while (root != null) {
                buf.push(root);
                root = root.left;
            }
            if (!buf.isEmpty()) {
                root = buf.pop();
            }
            iter.offer(root.val);
            root = root.right;
        }
    }

    /** @return the next smallest number */
    public int next() {
        return iter.pollFirst();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !iter.isEmpty();
    }
}

// push all left when calling next
//public class BSTIterator {
//    private Stack<TreeNode> stack = new Stack<TreeNode>();
//
//    public BSTIterator(TreeNode root) {
//        pushAll(root);
//    }
//
//    /** @return whether we have a next smallest number */
//    public boolean hasNext() {
//        return !stack.isEmpty();
//    }
//
//    /** @return the next smallest number */
//    public int next() {
//        TreeNode tmpNode = stack.pop();
//        pushAll(tmpNode.right);
//        return tmpNode.val;
//    }
//
//    private void pushAll(TreeNode node) {
//        for (; node != null; stack.push(node), node = node.left);
//    }
//}
