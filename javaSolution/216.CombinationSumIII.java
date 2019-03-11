import java.util.ArrayList;
import java.util.List;

class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        return findSums(k, 1, n);
    }

    private List<List<Integer>> findSums(int k, int start, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        if (k == 1) {
            if ( n < 10 && n >= start) {
                res.add(new ArrayList<>());
                res.get(0).add(n);
                return res;
            } else {
                return res;
            }
        }
        for (int i = start; i < 10; i++) {
            List<List<Integer>> childSums = findSums(k-1, i + 1, n - i);
            for (List<Integer> childSum : childSums) {
                List<Integer> oneResult = new ArrayList<>();
                oneResult.add(i);
                oneResult.addAll(childSum);
                res.add(oneResult);
            }
        }
        return res;
    }
}