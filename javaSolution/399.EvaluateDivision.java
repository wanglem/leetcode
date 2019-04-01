
import java.util.*;

// Google

/*
        "a/b=2, b/c=3" => "a --2--> b --3--> c"
        so "a/b * b/c" => a->b->c = 2*3 == 6
        build above graph in Map and run DFS
        Note:
            1. use Set<> to dedupe, prevent a/b -> b/a infinite loop
            2.
 */
class EvaluateDivision {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, List<String>> div = new HashMap<>();
        Map<String, List<Double>> divVal = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String dividend = equations[i][0];
            String divisor = equations[i][1];
            if (!div.containsKey(dividend)) {
                div.put(dividend, new ArrayList<>());
                divVal.put(dividend, new ArrayList<>());
            }
            if (!div.containsKey(divisor)) {
                div.put(divisor, new ArrayList<>());
                divVal.put(divisor, new ArrayList<>());
            }
            div.get(dividend).add(divisor);
            div.get(divisor).add(dividend);
            divVal.get(dividend).add(values[i]);
            divVal.get(divisor).add(1/values[i]);
        }

        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String dividend = queries[i][0];
            String divisor = queries[i][1];
            res[i] = searchGraph(div, divVal, dividend, divisor, new HashSet<>(), 1.0);
            if (res[i] == 0.0) res[i] = -1.0;
        }
        return res;
    }

    private double searchGraph(Map<String, List<String>> div, Map<String, List<Double>> divVal, String dividend, String divisor, Set<String> seen, double result) {
        if (seen.contains(dividend)) return 0.0;
        if (!div.containsKey(dividend)) return 0.0;
        if (dividend.equals(divisor)) return result;

        seen.add(dividend);
        List<String> allDivisors = div.get(dividend);
        double childResult = 0;
        for (int i = 0; i < allDivisors.size(); i++) {
            childResult = searchGraph(div, divVal, allDivisors.get(i), divisor, seen, result*divVal.get(dividend).get(i));
            if (childResult != 0.0) break;
        }
        seen.remove(dividend);
        return childResult;
    }
}