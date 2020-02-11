import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length+1; i++) {
            res.addAll(findSubsets(nums, 0, 0, i));
        }
        return res;
    }

    public List<List<Integer>> findSubsets(int[] A, int start, int len, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k == 0) {
            res.add(Collections.emptyList());
            return res;
        }
        if (k == A.length) {
            res.add(IntStream.of(A).boxed().collect(Collectors.toList()));
            return res;
        }
        if (len == k-1) {
            List<List<Integer>> arr = IntStream
                    .of(Arrays.copyOfRange(A, start, A.length))
                    .distinct()
                    .mapToObj(Collections::singletonList)
                    .collect(Collectors.toList());
            res.addAll(arr);
            return res;
        }

        Set<Integer> seen = new HashSet<>();
        for (int i = start; i < A.length; i++) {
            if (!seen.contains(A[i])) {
                seen.add(A[i]);
                List<List<Integer>> tails = findSubsets(A, i+1, len+1, k);
                int curVal = A[i];
                tails.forEach(x -> {
                    List<Integer> addCur = new ArrayList<>();
                    addCur.add(curVal);
                    addCur.addAll(x);
                    res.add(addCur);
                });
            }
        }
        return res;
    }
}