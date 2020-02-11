import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        return getCombo(n, 1, k);
    }

    private List<List<Integer>> getCombo(int n, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k == 1) {
            for (int i = start; i <= n; i++) {
                List<Integer> arr = new ArrayList<>();
                arr.add(i);
                res.add(arr);
            }
            return res;
        }
        for (int i = start; i <= n; i++) {
            List<List<Integer>> tails = getCombo(n, i+1, k-1);
            for (List<Integer> tail: tails) {
                List<Integer> curSet = new ArrayList<>(tail);
                curSet.add(0, i);
                res.add(curSet);
            }
        }
        return res;
    }
}