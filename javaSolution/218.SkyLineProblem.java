import java.util.*;

// MSFT
// Explaination: https://www.youtube.com/watch?v=GSBLe8cKu0s

class SkyLineProblem {

    private class BuildingLine {
        int idx;
        int height;
        boolean isStart;
        BuildingLine(int idx, int height, boolean isStart) {
            this.idx = idx;
            this.height = height;
            this.isStart = isStart;
        }
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<BuildingLine> lines = new ArrayList<>();

        for (int[] b: buildings) {
            lines.add(new BuildingLine(b[0], b[2], true));
            lines.add(new BuildingLine(b[1], b[2], false));
        }

        Collections.sort(lines, new Comparator<BuildingLine>() {
            @Override
            public int compare(BuildingLine o1, BuildingLine o2) {
                if (o1.idx != o2.idx) {
                    return Integer.compare(o1.idx, o2.idx);
                }

                if (o1.isStart && o2.isStart) {
                    return Integer.compare(o2.height, o1.height); // both start, higher height in front
                }

                if (!o1.isStart && !o2.isStart) {
                    return Integer.compare(o1.height, o2.height);
                }

//                if (o1.isStart ^ o2.isStart) { // must be true at this point.
                    return Integer.compare(o2.height, o1.height);
//                }
            }
        });

        TreeSet<Integer> order = new TreeSet<>();
        order.add(0);
        List<List<Integer>> res = new ArrayList<>();
        for (BuildingLine line: lines) {
            if (line.isStart) {
                order.add(line.height);
                if (order.last() <= line.height) {
                    res.add(Arrays.asList(line.idx, line.height));
                }
            } else {
                order.remove(line.height);
                if (order.last() < line.height) {
                    res.add(Arrays.asList(line.idx, order.last()));
                }
            }
        }
        return res;
    }
    
}