import java.util.List;
import java.util.Stack;

/*
    actionTime tracks time of an action - start/end.
    new task in `end`:
        1. time + durationBeforeInterrupted + (end.time - actionTime)
        2. move actionTime
    new task in `start`:
        1. add (`start`.time - actionTime) to previous task duration
        2. move actionTime
 */
// FB
class ExclusiveTimeOfFunctions {
    private class Task {
        int id;
        boolean isStart;
        int time;
        int durationBeforeInterrupted = 0;
        Task(int id, boolean isStart, int time) {
            this.id = id;
            this.isStart = isStart;
            this.time = time;
        }
    }
    // ["0:start:0","1:start:2","1:end:5","0:end:6"]
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Task> processes = new Stack<>();

        int[] duration = new int[n];
        int actionTime = 0; // action time tracks time of previous action
        for (String action: logs) {
            Task task = parseLog(action);
            if (task.isStart) {
                if (!processes.isEmpty()) {
                    processes.peek().durationBeforeInterrupted += task.time - actionTime;
                }
                processes.push(task);
                actionTime = task.time;
            } else {
                Task endingTask = processes.pop();
                // +1 below cuz current is end task, and endtime is inclusive
                int runtime = task.time - actionTime + 1 + endingTask.durationBeforeInterrupted;
                duration[endingTask.id] += runtime;
                actionTime = task.time + 1; // plus one cuz end time is inclusive.
            }

        }
        return duration;
    }

    // [id, isStart, time]
    private Task parseLog(String line) {
        String[] parsed = line.split(":");
        return new Task(Integer.parseInt(parsed[0]), parsed[1].equalsIgnoreCase("start"), Integer.parseInt(parsed[2]));
    }
}