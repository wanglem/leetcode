import java.util.Comparator;
import java.util.PriorityQueue;

// BB, 2N people, 2 city, fly N people to each.
// costs[i][0] cost[i][1] -> send ith ppl to city 0/1
// find min cost

// Greedy method that sort by diff to minimize total min, NOT sort by cost
class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        PriorityQueue<int[]> personToCity = new PriorityQueue<>(Comparator.comparingInt(x -> x[0] - x[1]));
        for (int[] cost: costs) {
            personToCity.offer(cost);
        }
        int minCost = 0;

        int count = 0;
        while (!personToCity.isEmpty()) {
            int[] next = personToCity.poll();
            if (count++ < costs.length/2) {
                minCost += next[0];
            } else {
                minCost += next[1];
            }
        }
        return minCost;
    }
}