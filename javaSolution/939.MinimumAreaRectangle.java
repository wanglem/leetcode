import java.util.*;

// Google
/*
    1. Enumerate rows.
    2. From furthest to closest points on that row, and furthest to closest points on that column. Try form a rectangle.
    3. time complexity O(n^2)
 */
class MinimumAreaRectangle {
    public int minAreaRect(int[][] points) {
        Map<Integer, List<Integer>> rows = new HashMap<>();
        Map<Integer, List<Integer>> cols = new HashMap<>();
        for (int[] p : points) {
            rows.computeIfAbsent(p[0], x -> new ArrayList<>()).add(p[1]);
            cols.computeIfAbsent(p[1], x -> new ArrayList<>()).add(p[0]);
        }
        List<Integer> allRows = new ArrayList<>(rows.keySet());
        Collections.sort(allRows);
        int maxArea = 0;
        for (Integer oneRow: allRows) {
            List<Integer> colOfRow = rows.get(oneRow);
            Collections.sort(colOfRow, Collections.reverseOrder());
            for (Integer c : colOfRow) {
                List<Integer> rowOfCol = cols.get(c);
                Collections.sort(rowOfCol, Collections.reverseOrder());
                for (Integer r: rowOfCol) {
                    for (Integer tryCol : colOfRow) {
                        if (cols.containsKey(tryCol) && cols.get(tryCol).contains(r)) {
                            maxArea = Math.max(maxArea, (c - tryCol+1)*(r-oneRow+1));
                        }
                    }
                }
            }
        }
        return maxArea;
    }
}