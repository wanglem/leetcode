import java.util.LinkedList;
import java.util.Queue;

// FB
/*
    1. build a graph
    2. start with one node, each layer is a group, mark them 1 or 2.
    3. return false if existed and conflicted
 */
class IsGraphBipartite{
    public boolean isBipartite(int[][] graph) {
        int[] group = new int[graph.length];
        for (int i = 0; i < group.length; i++) {
            if (!groupNodes(graph, group, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean groupNodes(int[][] graph, int[] group, int node) {
        Queue<Integer> process = new LinkedList<>();
        process.offer(node);
        while(!process.isEmpty()) {
            int last = process.poll();
            if (group[last] != 0) {
                continue;
            }
            group[last] = 1;
            for (int neighbor : graph[last]) {
                if (group[neighbor] != 0) {
                    continue;
                }
                if (group[neighbor] == group[last]) {
                    return false;
                } else if (group[neighbor] == 0) {
                    group[neighbor] = group[last] == 1 ? 2 : 1;
                    process.offer(neighbor);
                }
            }
        }
        return true;
    }
}