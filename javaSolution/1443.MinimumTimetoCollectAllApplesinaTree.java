import java.util.*;

class MinimumTimetoCollectAllApplesinaTree {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] e: edges) {
            graph.putIfAbsent(e[0], new ArrayList<>());
            graph.putIfAbsent(e[1], new ArrayList<>());
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];
        return traverse(0, graph, visited, hasApple);
        
    }

    private int traverse(int start, Map<Integer, List<Integer>> graph, boolean[] visited, List<Boolean> hasApple) {
        if (visited[start]) return 0;

        int walked = 0;

        visited[start] = true;
        for (int child: graph.getOrDefault(start, Collections.emptyList())) {
            walked += traverse(child, graph, visited, hasApple);
        }

        if ((walked > 0 || hasApple.get(start)) && start != 0) {
            walked += 2;
        }

        return walked;
    }
}