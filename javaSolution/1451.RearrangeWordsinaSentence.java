import java.util.PriorityQueue;

class RearrangeWordsinaSentence {
    public String arrangeWords(String text) {
        String[] words = text.split(" ");
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> {
            if (x[1] == y[1]) {
                return Integer.compare(x[0], y[0]);
            }
            return Integer.compare(x[1], y[1]);
        });
        for (int i = 0; i < words.length; i++) {
            pq.offer(new int[]{i, words[i].length()});
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] next = pq.poll();
            String word = words[next[0]];
            if (next[0] == 0) {
                word = word.toLowerCase();
            }
            if (sb.length() == 0) {
                sb.append(word.substring(0, 1).toUpperCase());
                word = word.substring(1);
            }
            sb.append(word);
            sb.append(" ");
        }

        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}