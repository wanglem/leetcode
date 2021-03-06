
import java.util.ArrayList;
import java.util.List;

// generate all possible BST from 1 to n
// use each i between [1,n] as root, recursively generate left(1, i) and right(i, n)
class UniqueBinarySearchTreeII {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return generateTreesBetween(1, n);
    }

    private List<TreeNode> generateTreesBetween(int start, int end) {
        ArrayList<TreeNode> res = new ArrayList<>();
        if (start == end) {
            res.add(new TreeNode(start));
            return res;
        }
        if (start > end) {
            res.add(null);
            return res;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> left = generateTreesBetween(start, i - 1);
            List<TreeNode> right = generateTreesBetween(i+1, end);
            for (TreeNode lnode : left) {
                for (TreeNode rnode : right) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = lnode;
                    cur.right = rnode;
                    res.add(cur);
                }
            }
        }
        return res;
    }
}