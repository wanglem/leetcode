import java.util.List;
import java.util.Stack;

class ExclusiveTimeOfFunctions {
    class Task {
        int id;
        boolean isStart;
        int time;
        int interrupted = -1;
        int resumed = -1;
        Task(int id, boolean isStart, int time) {
            this.id = id;
            this.isStart = isStart;
            this.time = time;
        }
    }
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] runtime = new int[n];
        Stack<Task> tasks = new Stack<>();
        for (String line: logs) {
            Task next = parseLog(line);
            if (next.isStart) {
                if (!tasks.isEmpty()) {
                    tasks.peek().interrupted = next.time - 1;
                }
                tasks.push(next);
            } else {
                Task start = tasks.pop();
                if (start.interrupted == -1) {
                    runtime[next.id] += next.time - start.time + 1;
                } else {
                    runtime[next.id] += next.time - start.resumed + 1 + start.interrupted - start.time + 1;
                }
                if (!tasks.isEmpty()) {
                    tasks.peek().resumed = next.time + 1;
                }
            }
        }
        return runtime;
    }

    // [id, isStart, time]
    private Task parseLog(String line) {
        String[] parsed = line.split(":");
        return new Task(Integer.parseInt(parsed[0]), parsed[1].equals("start"), Integer.parseInt(parsed[2]));
    }
}