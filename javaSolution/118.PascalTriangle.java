import java.util.ArrayList;
import java.util.List;

// too easy.. ignore
class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<Integer> curRow = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0){
            return res;
        }
        if (numRows == 1) {
            curRow.add(1);
            res.add(curRow);
            return res;
        }
        List<List<Integer>> childRes = generate(numRows - 1);
        List<Integer> lastRow = childRes.get(childRes.size() - 1);
        for (int i = 0; i < numRows; i++) {
            if ( i == 0 || i == numRows - 1) {
                curRow.add(1);
            } else {
                curRow.add(lastRow.get(i-1) + lastRow.get(i));
            }
        }
        childRes.add(curRow);
        return childRes;
    }
}