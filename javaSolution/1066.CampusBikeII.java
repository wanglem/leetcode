import java.util.*;

/*
    Amazon.
    Dijkstra problem.
    1. Intial State -> no worker, no bike, zero cost.
    2. BFS to search till reach state -> all workers got a bike.
    3. Use a PriorityQueue (by minCost) to maintain BFS search order.
    4. Improve speed by only enqueue state if it's less than previous state's minCost
        1. Previous state defined as (worker i, bikeAssginment boolean[bike.length]).
 */
class CampusBikeII {
    private class Path {
        int cost;
        Edge e;
        Path(int c, Edge ec) {
            cost = c;
            e = ec;
        }

    }

    private class Edge {
        int worker;
        boolean[] bikeAssigned;
        Edge(int w, boolean[] b) {
            worker = w;
            bikeAssigned = Arrays.copyOf(b, b.length);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj.getClass() != this.getClass()) return false;
            Edge o = (Edge) obj;
            if (worker != o.worker) return false;
            if (bikeAssigned.length != o.bikeAssigned.length) return false;
            for (int i = 0; i < bikeAssigned.length; i++) {
                if (bikeAssigned[i] != o.bikeAssigned[i]) return false;
            }
            return true;
        }

        @Override
        public int hashCode() {
            int r = 1;
            for (boolean b: bikeAssigned) {
                r <<= 1;
                r |=  b ? 1 : 0;
            }
            return r*10 + worker;
        }
    }
    public int assignBikes(int[][] workers, int[][] bikes) {
        PriorityQueue<Path> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.cost));

        pq.offer(new Path(0, new Edge(0, new boolean[bikes.length])));
        Map<Edge, Integer> minCost = new HashMap<>();
        while (!pq.isEmpty()) {
            Path next = pq.poll();
            if (next.e.worker == workers.length) {
                return next.cost;
            }

            for (int i = 0; i < bikes.length; i++) {
                if (!next.e.bikeAssigned[i]) {
                    int newCost = next.cost +
                            Math.abs(workers[next.e.worker][0] - bikes[i][0]) +
                            Math.abs(workers[next.e.worker][1] - bikes[i][1]);

                    Path p = new Path(newCost, new Edge(next.e.worker+1, next.e.bikeAssigned));
                    p.e.bikeAssigned[i] = true;
                    if (minCost.containsKey(p.e) && minCost.get(p.e) <= p.cost) continue;
                    minCost.put(p.e, p.cost);
                    pq.offer(p);
                }
            }
        }
        return -1;
    }

}