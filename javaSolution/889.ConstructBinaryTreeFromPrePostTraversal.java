import java.util.Arrays;

/*
    Level order tree: [1,2,3,4,5,6,7]
    PreOrder Traversal: [[1],[2,4,5],[3,6,7]]
    PostOrder Traversal: [[4,5,2],[6,7,3],[1]]
    Notice the partition of left and right:
        PreOrder: 2 is at left branch first element
        PostOrder: 2 is at left branch last element
        Same for 3.
 */
class ConstructBinaryTreeFromPrePostTraversal {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre.length == 0) return null;
        TreeNode root = new TreeNode(pre[0]);
        if (pre.length == 1) return root;

        int leftEnd = 0;
        while (leftEnd < post.length) {
            if (post[leftEnd] == pre[1]) {
                break;
            }
            leftEnd++;
        }

        root.left = constructFromPrePost(
                Arrays.copyOfRange(pre, 1, leftEnd+2),
                Arrays.copyOfRange(post, 0, leftEnd+1));
        root.right = constructFromPrePost(
                Arrays.copyOfRange(pre, leftEnd+2, pre.length),
                Arrays.copyOfRange(post, leftEnd+1, post.length-1));

        return root;
    }
}