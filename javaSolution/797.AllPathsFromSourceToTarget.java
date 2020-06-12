import java.util.*;

// DFS
class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        for (int[] connected: graph) {
            Arrays.sort(connected);
        }
        return findAllPaths(graph, new HashSet<>(), 0);
    }

    private List<List<Integer>> findAllPaths(int[][] graph, Set<Integer> visited, int current) {
        List<List<Integer>> res = new ArrayList<>();
        if (visited.contains(current)) {
            return res;
        }

        if (current == graph.length - 1) {
            res.add(Arrays.asList(current));
            return res;
        }

        visited.add(current);
        for (int nextJump: graph[current]) {
            List<List<Integer>> foundJumps = findAllPaths(graph, visited, nextJump);
            for (List<Integer> foundJump: foundJumps) {
                List<Integer> path = new ArrayList<>();
                path.add(current);
                path.addAll(foundJump);
                res.add(path);
            }
        }
        visited.remove(current);

        return res;
    }
}