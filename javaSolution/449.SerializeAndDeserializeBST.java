

import java.util.*;
import java.util.stream.Collectors;

class SerializeAndDeserializeBST {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> nodes = new ArrayList<>();
        for (String[] node: convert(root, 0)) {
            nodes.add(node[0] + "#" + node[1]);
        }

        return String.join(",", nodes);
    }

    private List<String[]> convert(TreeNode root, int idx) {
        List<String[]> res = new ArrayList<>();
        if (root == null) return res;

        res.add(new String[]{String.valueOf(idx), String.valueOf(root.val)});
        res.addAll(convert(root.left, 2*idx+1));
        res.addAll(convert(root.right, 2*idx+2));
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        List<String[]> nodes = Arrays.stream(data.split(","))
                .map(x -> x.split("#"))
                .collect(Collectors.toList());
        Map<Long, TreeNode> idxNode = new HashMap<>();
        for (int i = nodes.size() - 1; i >= 0; i--) {
            String[] n = nodes.get(i);
            long idx = Long.valueOf(n[0]);
            TreeNode node = new TreeNode(Integer.valueOf(n[1]));
            idxNode.put(idx, node);
            node.left = idxNode.getOrDefault(2*idx + 1, null);
            node.right = idxNode.getOrDefault(2*idx + 2, null);
        }

        return idxNode.get(0L);
    }
}