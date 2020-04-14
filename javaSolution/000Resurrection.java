import java.util.*;

class Resurrection {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> courseToPre = new HashMap<>();
        for (int[] p: prerequisites) {
            if (!courseToPre.containsKey(p[0])) {
                courseToPre.put(p[0], new HashSet<>());
            }
            courseToPre.get(p[0]).add(p[1]);
        }

        boolean[] seen = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (seen[i]) continue;
            boolean circle = hasCircle(courseToPre, i, new boolean[numCourses], seen);
            if (circle) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCircle(Map<Integer, Set<Integer>> courseToPre, int course, boolean[] visited, boolean[] seen) {
        if (visited[course]) return true;
        seen[course] = true;

        visited[course] = true;
        for (int pre: courseToPre.getOrDefault(course, new HashSet<>())) {
            boolean circle = hasCircle(courseToPre, pre, visited, seen);
            if (circle) return true;
        }
        visited[course] = false;

        return false;
    }
    
}
