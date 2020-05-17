import java.util.Arrays;

class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        int split = findIndex(inorder, root.val);
        root.left = buildTree(
                Arrays.copyOfRange(preorder, 1, split + 1),
                Arrays.copyOfRange(inorder, 0, split));

        root.right = buildTree(
                Arrays.copyOfRange(preorder, split+1, preorder.length),
                Arrays.copyOfRange(inorder, split+1, inorder.length)
        );
        
        return root;
    }

    private int findIndex(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }

        return -1;
    }
}