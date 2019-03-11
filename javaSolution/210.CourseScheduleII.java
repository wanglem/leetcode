import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Set<Integer>> deps = new HashMap<>();
        for (int[] dep : prerequisites) {
            Set<Integer> pre = deps.getOrDefault(dep[0], new HashSet<>());
            pre.add(dep[1]);
            deps.put(dep[0], pre);
        }
        Stack<Integer> sortStack = new Stack<>();
        for (int i = 0; i< numCourses; i++) {
            if (deps.containsKey(i)) {
                continue;
            }
            sort(deps, new HashSet<>(), i, sortStack);
            if (sortStack.isEmpty())  {
                return new int[]{};
            }
        }
        if (sortStack.size() != numCourses) {
            return new int[]{};

        }
        return toOrder(sortStack);
    }
    private int[] toOrder(Stack<Integer> stack) {
        int[] ordered = new int[stack.size()];
        for (int i = 0; i<stack.size(); i++) {
            ordered[i] = stack.pop();
        }
        return ordered;
    }
    private void sort(HashMap<Integer, Set<Integer>> deps, Set<Integer> seen, Integer root, Stack<Integer> sortStack){
        if (seen.contains(root)) {
            sortStack.clear();
            return;
        }
        if (!deps.containsKey(root)) {
            sortStack.push(root);
            return;
        }
        seen.add(root);
        for (Integer pre : deps.get(root)) {
            sort(deps, seen, pre, sortStack);
            if (sortStack.isEmpty()) {
                return;
            }
            sortStack.push(pre);
        }
        seen.remove(root);
    }

}