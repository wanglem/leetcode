import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 2; i < nums.length; i++) {
            res.addAll(subsetsK(nums, 0, i));
        }

        res.add(Collections.emptyList());
        if (nums.length > 1) {
            res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != nums.length - 1 && nums[i] == nums[i+1]) continue;
            res.add(Collections.singletonList(nums[i]));
        }

        return res;
    }

    private List<List<Integer>> subsetsK(int[] nums, int start, int K) {
        if (start >= nums.length) return Collections.emptyList();

        List<List<Integer>> res = new ArrayList<>();
        if (K == 1) {
            for (int i = start; i < nums.length; i++) {
                if (i == start || nums[i] != nums[i-1]) {
                    res.add(Collections.singletonList(nums[start++]));
                }
            }
            return res;
        }

        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i-1]) continue;
            List<List<Integer>> tailList = subsetsK(nums, i+1, K-1);
            for (List<Integer> tail: tailList) {
                List<Integer> sub = new ArrayList<>();
                sub.add(nums[i]);
                sub.addAll(tail);
                res.add(sub);
            }
        }

        return res;
    }
}