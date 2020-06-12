import java.util.*;

/**
 * FB
 * Topological sort:
 *   1. Build graph:
 *       1. a map of character -> set of character.
 *       2. Also get in-degrees. In-degrees will be a map of character -> integer.
 *   2. Topological sort:
 *       1. Loop through in-degrees. Offer the characters with in-degree of 0 to queue.
 *       2. While queue is not empty:
 *           1. Poll from queue. Append to character to result string.
 *           2. Decrease the in-degree of polled character's children by 1.
 *           3. If any child's in-degree decreases to 0, offer it to queue.
 *       3. At last, if result string's length is less than the number of vertices,
 *          that means there is a cycle in my graph. The order is invalid.
 */
class AlienDictionary {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        int[] inDegree = new int[26];
        buildGraph(words, graph, inDegree);

        String order = topologicalSort(graph, inDegree);
        return order.length() == graph.size() ? order : "";
    }

    private void buildGraph(String[] words, Map<Character, Set<Character>> graph, int[] inDegree) {
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.put(c, new HashSet<>());
            }
        }

        for (int i = 1; i < words.length; i++) {
            String first = words[i - 1];
            String second = words[i];
            int length = Math.min(first.length(), second.length());

            for (int j = 0; j < length; j++) {
                char parent = first.charAt(j);
                char child = second.charAt(j);
                if (parent != child) {
                    if (!graph.get(parent).contains(child)) {
                        graph.get(parent).add(child);
                        inDegree[child - 'a']++;
                    }
                    break;
                }
            }
        }
    }

    private String topologicalSort(Map<Character, Set<Character>> graph, int[] inDegree) {
        Queue<Character> queue = new LinkedList<>();
        for (char c : graph.keySet()) {
            if (inDegree[c - 'a'] == 0) {
                queue.offer(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            for (char neighbor : graph.get(c)) {
                inDegree[neighbor - 'a']--;
                if (inDegree[neighbor - 'a'] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        return sb.toString();
    }
}