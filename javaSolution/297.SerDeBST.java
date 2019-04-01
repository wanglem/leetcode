import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.

 */
class Codec {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    private class IndexedTreeNode {
        int index;
        TreeNode node;
        IndexedTreeNode(int i, TreeNode n) {index=i; node=n;}
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, 1, sb);
        return sb.toString();
    }
    private void serialize(TreeNode root, int index, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append('(');
        sb.append(index);
        sb.append(',');
        sb.append(root.val);
        sb.append(')');
        serialize(root.left, 2*index-1, sb);
        serialize(root.right, 2*index+1, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        TreeNode root = null;
        Queue<IndexedTreeNode> process = new LinkedList<>();
        int[] serNode = nextNode(data, 0);
        int i = serNode[2];
        process.offer(new IndexedTreeNode(serNode[0], new TreeNode(serNode[1])));
        root = process.peek().node;
        while (i < data.length()) {
            serNode = nextNode(data, i);
            IndexedTreeNode lastNode = process.poll();
            while (serNode[0] != 2*lastNode.index-1 || serNode[0] != 2*lastNode.index+1 ) {
                lastNode = process.poll();
            }
            if (serNode[0] == 2*lastNode.index - 1) {
                lastNode.node.left = new TreeNode(serNode[1]);
                process.offer(new IndexedTreeNode(2*lastNode.index-1, lastNode.node.left));
            } else if (serNode[0] == 2*lastNode.index + 1) {
                lastNode.node.right = new TreeNode(serNode[1]);
                process.offer(new IndexedTreeNode(2*lastNode.index+1, lastNode.node.right));
            }
            i = serNode[2];
        }
        return root;
    }
    private int[] nextNode(String data, int i) {
        // should check input state
        int j = i;
        while (data.charAt(j) != ')') j++; // should check index out of bound
        String[] serNode = data.substring(i+1, j).split(",");
        return new int[] {Integer.getInteger(serNode[0]), Integer.getInteger(serNode[1]), j+1};
    }
}
