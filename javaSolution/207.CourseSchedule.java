import java.util.*;

class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Set<Integer>> deps = new HashMap<>();
        for (int[] dep : prerequisites) {
            Set<Integer> pre = deps.getOrDefault(dep[0], new HashSet<>());
            pre.add(dep[1]);
            deps.put(dep[0], pre);
        }
        boolean[] processed = new boolean[numCourses];
        for (int i = 0; i< numCourses; i++) {
            if (processed[i]) {
                continue;
            }
            boolean hasCircularDep = searchCircularBranch(deps, new HashSet<>(), i, processed);
            if (hasCircularDep)  {
                return false;
            }
        }
        return true;
    }
    private boolean searchCircularBranch(HashMap<Integer, Set<Integer>> deps, Set<Integer> seen, Integer root, boolean[] processed){
        processed[root] = true;
        if (seen.contains(root)) {
            return true;
        }
        if (!deps.containsKey(root)) {
            return false;
        }
        seen.add(root);
        for (Integer pre : deps.get(root)) {
            boolean isCircular = searchCircularBranch(deps, seen, pre, processed);
            if (isCircular) {
                return true;
            }
        }
        seen.remove(root);
        return false;
    }
}