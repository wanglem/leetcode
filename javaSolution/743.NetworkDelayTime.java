import java.util.*;

/*
    G.
    Dijkstra.
    Search with State, cost function sortedin priority queue.
 */
class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int N, int K) {
        // <From, List<[To, Cost]>>
        Map<Integer, List<int[]>> send = new HashMap<>();
        for (int[] t: times) {
            if (!send.containsKey(t[0])) {
                send.put(t[0], new ArrayList<>());
            }
            send.get(t[0]).add(new int[]{t[1], t[2]});
        }
        boolean[] seen = new boolean[N+1];
        int seenCount = 0;
        // [To, Time]
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));
        pq.offer(new int[]{K, 0});
        while (!pq.isEmpty()) {
            int[] first = pq.poll();
            if (seen[first[0]]) continue;
            seenCount++;
            if (seenCount == N) return first[1];
            seen[first[0]] = true;
            if (send.containsKey(first[0])) {
                for (int[] next: send.get(first[0])) {
                    pq.offer(new int[]{next[0], first[1] + next[1]});
                }
            }
        }

        return -1;
    }
}