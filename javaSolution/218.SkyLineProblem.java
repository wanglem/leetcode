import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SkyLineProblem {

    private class Building {
        int start;
        int end;
        int height;
        Building(int s, int e, int h){
            start = s;
            end = e;
            height = h;
        }
    }
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<Building> b = new ArrayList<>();
        for (int[] bu: buildings) {
            b.add(new Building(bu[0], bu[1], bu[2]));
        }

        return toReturnValue(concat(breakUp(b)));


    }

    private List<Building> breakUp(List<Building> b) {
        List<Building> res = new ArrayList<>();
        Building toMerge = null;
        for (int i = 0; i < b.size(); i++) {
            Building cur = b.get(i);
            if (toMerge == null) {
                toMerge = cur;
                continue;
            }
            if (toMerge.end <= cur.start) { // no overlap
                res.add(toMerge);
                toMerge = cur;
                continue;
            }
            if (toMerge.start < cur.start) {
                res.add(new Building(toMerge.start, cur.start, toMerge.height));
            }
            res.add(new Building(cur.start, Math.min(toMerge.end, cur.end), Math.max(toMerge.height, cur.height)));
            if (toMerge.end > cur.end) {
                toMerge = new Building(cur.end, toMerge.end, toMerge.height);
            } else if (toMerge.end < cur.end) {
                toMerge = new Building(toMerge.end, cur.end, cur.height);
            } else {
                toMerge = null;
            }
        }
        if (toMerge != null) res.add(toMerge);
        return res;
    }

    private List<Building> concat(List<Building> b) {
        List<Building> res = new ArrayList<>();
        Building toConcat = null;
        for (int i = 0; i < b.size(); i++) {
            Building cur = b.get(i);
            if (toConcat == null) {
                toConcat = cur;
                continue;
            }
            if (toConcat.height == cur.height) {
                toConcat.end = cur.end;
            } else {
                res.add(toConcat);
                toConcat = cur;
            }
        }

        res.add(toConcat);
        return res;
    }

    private List<List<Integer>> toReturnValue(List<Building> b) {
        List<List<Integer>> res = new ArrayList<>();
        int preEnd = -1;
        for (int i = 0; i < b.size(); i++) {
            Building cur = b.get(i);
            if (preEnd > 0 && preEnd < cur.start) {
                res.add(Arrays.asList(preEnd, 0));
            }
            res.add(Arrays.asList(cur.start, cur.height));
            preEnd = cur.end;
        }
        res.add(Arrays.asList(preEnd, 0));
        return res;
    }
    
}