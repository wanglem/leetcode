import java.util.*;
import java.util.stream.Collectors;

class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> courseToPre = new HashMap<>();
        for (int[] p: prerequisites) {
            if (!courseToPre.containsKey(p[0])) {
                courseToPre.put(p[0], new HashSet<>());
            }
            courseToPre.get(p[0]).add(p[1]);
        }

        Stack<Integer> order = new Stack<>();
        boolean[] processed = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (processed[i]) continue;
            boolean learnt = learn(i, courseToPre, new boolean[numCourses], order, processed);
            if (!learnt) return new int[numCourses];
        }

        int[] ans = new int[numCourses];
        for (int i = numCourses - 1; i >= 0; i--){
            ans[i] = order.pop();
        }
        return ans;
    }

    private boolean learn(int start, Map<Integer, Set<Integer>> courseToPre, boolean[] visited, Stack<Integer> order, boolean[] processed) {
        if (visited[start]) return false;
        if (processed[start]) return true;
        processed[start] = true;
        visited[start] = true;

        for (int pre: courseToPre.getOrDefault(start, new HashSet<>())) {
            boolean learnt = learn(pre, courseToPre, visited, order, processed);
            if (!learnt) return false;
        }
        order.push(start);
        visited[start] = false;
        return true;
    }
    

}