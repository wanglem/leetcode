import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
    G.
    Similar to a hashing ring thing.
 */
class RandomPickWithWeight {
    private int total = 0;
    private List<Integer> n = new ArrayList<>();
    private Random r;
    public RandomPickWithWeight(int[] w) {
        r = new Random();
        for (int wi: w) {
            total += wi;
            n.add(total);
        }
    }

    public int pickIndex() {
        int target = r.nextInt(total) + 1;
        int left = 0, right = n.size();
        while (left < right) {
            int mid = (right-left)/2 + left;
            if (n.get(mid) < target) left = mid+1;
            else right = mid;
        }
        return left;
    }
}