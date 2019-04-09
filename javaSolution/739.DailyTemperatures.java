import java.util.Stack;

// Google
// how many days to wait till warmer temperature
/*
    use a stack to maintain decreasing temperatures.
 */
class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int N = T.length;
        int[] waits = new int[N];
        waits[N - 1] = 0;
        Stack<Integer> waiting = new Stack<>();
        for (int i = 0; i < N - 1; i++) {
            if (T[i] < T[i + 1]) {
                while (waiting.size() > 0 && T[waiting.peek()] < T[i + 1]) {
                    int toFill = waiting.pop();
                    waits[toFill] = i + 1 - toFill;
                }
                waits[i] = 1;
            } else {
                waiting.push(i);
            }
        }
        while (waiting.size() > 0) {
            waits[waiting.pop()] = 0;
        }
        return waits;
    }
}