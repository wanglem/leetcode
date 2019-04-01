import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

// Google
class MinimumCostToHireKWorkers {

    /*
        1. key observation, for whole group: wage[k]/quality[k] must be the same.
        2. sort the inputs by wage/quality ratio, get sliding window of K
        3. a newer ratio means smallest pay increased to all K members.
            3a. We want to remove the highest quality one and add this one.
        4. iterate over and find minCost of each K groups.
     */
    public double mincostToHireWorkersHeap(int[] quality, int[] wage, int K) {
        int N = quality.length;
        int[][] workers = new int[N][2];
        for (int i = 0; i < N; i++) {
            workers[i][0] = quality[i];
            workers[i][1] = wage[i];
        }
        // sort by ratio
        Arrays.sort(workers, Comparator.comparingDouble(a -> (double) a[1]/a[0]));
        PriorityQueue<Integer> group = new PriorityQueue<>(Collections.reverseOrder());
        double cost = Double.MAX_VALUE;
        int totalQuality = 0;
        for (int[] worker : workers) {
            group.offer(worker[0]);
            totalQuality += worker[0];
            if (group.size() > K) {
                totalQuality -= group.poll();
            }
            if (group.size() == K) {
                cost = Math.min(cost, (double)totalQuality*worker[1]/worker[0]);
            }
        }
        return cost;
    }

    /*
        Greedy solution
        1. for a group of K, at least 1 worker will receive minimum wage
        2. the worker (i) receive min wage is baseline.
        3. Worker (k): wage[i]/quality[i] * quality[k]
        Note: if calculated pay price < its min wage. Then skip, because the chosen worker can't be minWage in this group.
    */
    public double mincostToHireWorkersGreedy(int[] quality, int[] wage, int K) {
        double minCost = Double.MAX_VALUE;
        for (int i = 0; i < wage.length; i++) {
            double factor = (1.0*wage[i])/quality[i];
            double[] pays = new double[wage.length];
            int m = 0;
            for (int j = 0; j < wage.length; j++) {
                double toPay = quality[j] * factor;
                if (toPay < wage[j]) continue;
                pays[m++] = toPay;
            }
            if (m < K) continue;
            Arrays.sort(pays,0, m);
            double cost = 0;
            for (int j = 0; j < K; j++) {
                cost += pays[j];
            }
            minCost = Math.min(cost, minCost);
        }
        return minCost;
    }
}