import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        return stack(root);
    }


    List<Integer> recursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        res.addAll(inorderTraversal(root.left));
        res.add(root.val);
        res.addAll(inorderTraversal(root.right));
        return res;
    }

    List<Integer> stack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> buf = new Stack<>();
        while (root != null) {
            buf.push(root);
            root = root.left;
        }
        while (!buf.isEmpty()){
            TreeNode prev = buf.pop();
            res.add(prev.val);
            TreeNode right = prev.right;
            while (right != null) {
                buf.push(right);
                right = right.left;
            }
        }
        return res;
    }

}