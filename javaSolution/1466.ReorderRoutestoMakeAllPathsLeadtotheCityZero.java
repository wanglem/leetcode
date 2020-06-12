import java.util.*;

class ReorderRoutestoMakeAllPathsLeadtotheCityZero {
    public int minReorder(int n, int[][] connections) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Set<Integer>> direction = new HashMap<>();

        for (int[] c: connections) {
            graph.putIfAbsent(c[0], new HashSet<>());
            graph.get(c[0]).add(c[1]);
            graph.putIfAbsent(c[1], new HashSet<>());
            graph.get(c[1]).add(c[0]);
            direction.putIfAbsent(c[0], new HashSet<>());
            direction.get(c[0]).add(c[1]);
        }

        boolean[] seen = new boolean[n];
        seen[0] = true;
        int orderChanged = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int inner = q.poll();
                for (int outer: graph.get(inner)) {
                    if (seen[outer]) continue;
                    seen[outer] = true;
                    q.offer(outer);
                    if (!direction.getOrDefault(outer, new HashSet<>()).contains(inner)) {
                        orderChanged++;
                    }
                }
                
            }
        }
        return orderChanged;
    }

}