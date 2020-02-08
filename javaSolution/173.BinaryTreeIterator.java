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

    private Stack<TreeNode> buf = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushLeft(root);
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode prev = buf.pop();
        pushLeft(prev.right);
        return prev.val;

    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !buf.isEmpty();
    }

    private void pushLeft(TreeNode node) {
        while (node != null) {
            buf.push(node);
            node = node.left;
        }
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
