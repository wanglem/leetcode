import java.util.*;
import java.util.stream.Collectors;

import java.io.*;

class MyCode {
    private static Stack<Integer> path;

    public static void main(String[] args) {
        List<Integer> testInput0 = new ArrayList<Integer>();
        List<Integer> testInput1 = new ArrayList<Integer>();
        List<Integer> testInput2 = new ArrayList<Integer>();
        testInput0.add(2);
        testInput0.add(4);
        testInput0.add(1);
        testInput0.add(1);
        testInput0.add(0);
        testInput0.add(4);
        testInput2.add(1);
        testInput2.add(1);
        testInput2.add(1);
        testInput2.add(2);
        testInput2.add(0);
        testInput2.add(1);

        System.out.println(canReachEnd(testInput0)); // 0, 1
        // System.out.println(canReachEnd(testInput1)); // empty
        // System.out.println(canReachEnd(testInput2)); // 0, 1, 2, 3

    }

    public static List<Integer> canReachEnd(List<Integer> list) {
        path = new Stack<Integer>();
        if (list.size() > 0) {
            findPath(0, list);
        }
        return new ArrayList<>(path);
    }

// input = { 2,4,1,1,0,4 }
// input = { 2,1,0,4 }

    private static boolean findPath(int startIdx, List<Integer> list) {
        if (startIdx >= list.size() - 1) return true;
        path.push(startIdx);
        int steps = list.get(startIdx);
        for (int i = startIdx + steps; i > startIdx; i--) {
            boolean reached = findPath(i, list);
            if (reached) return true;
        }
        path.pop();

        return false;
    }
}
