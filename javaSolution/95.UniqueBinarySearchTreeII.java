
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

class UniqueBinarySearchTreeII {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
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