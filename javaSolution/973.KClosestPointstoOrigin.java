import java.util.Comparator;
import java.util.PriorityQueue;

// FB
// this is nlogn cuz we push all points to priority queue.
// to keep nlongk, we need pop when pq reachs k size, then push.
class KClosestPointstoOrigin {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                Comparator.comparingInt(x -> -(x[0]*x[0] + x[1]*x[1])));

        for (int[] p: points) {
            pq.offer(p);
            if (pq.size() > K) {
                pq.poll();
            }
        }

        int[][] res = new int[K][2];

        for (int i = 0; i < K; i++) {
            res[i] = pq.poll();
        }

        return res;
    }
}