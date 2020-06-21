import java.util.Stack;

//FB
class RangeSumOfBST {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;

        int sum = 0;
        sum += rangeSumBST(root.left, L, R);
        sum += rangeSumBST(root.right, L, R);
        if (root.val <= R && root.val >= L) {
            sum += root.val;
        }
        return sum;
    }

    public int rangeSumBSTIter(TreeNode root, int L, int R) {
        Stack<TreeNode> st = new Stack<>();
        int sum = 0;
        while (!st.isEmpty() || root != null) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }
            TreeNode last = st.pop();
            if (last.val > R) break;
            if (last.val <= R && last.val >= L) {
                sum += last.val;
            }
            root = last.right;
        }
        return sum;
    }

}