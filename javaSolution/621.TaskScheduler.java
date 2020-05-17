import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

// fb, g
/*
       1. Queue to maintain tasks in cooldown, dequeue when cooldown finish
       2. PriorityQueue to poll task with largest count
 */
class TaskScheduler {
    class Task {
        int task;
        int count;
        int lastSchedule;
        public Task (int task, int count, int lastSchedule) {
            this.task = task;
            this.count = count;
            this.lastSchedule = lastSchedule;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        Queue<Task> cooldowns = new LinkedList<>();
        PriorityQueue<Task> scheduler = new PriorityQueue<>((x, y) -> y.count - x.count);
        int[] taskCounts = new int[26];
        for (char c : tasks) {
            taskCounts[c - 'A']++;
        }
        for (int i = 0; i < 26; i++) {
            if (taskCounts[i] > 0) {
                scheduler.offer(new Task(i, taskCounts[i], 0));
            }
        }

        int schedules = 0;
        while (!cooldowns.isEmpty() || !scheduler.isEmpty()) {
            while (!cooldowns.isEmpty() && schedules - cooldowns.peek().lastSchedule - 1 >= n) {
                scheduler.offer(cooldowns.poll());
            }
            if (scheduler.isEmpty()) {
                schedules += n - (schedules - cooldowns.peek().lastSchedule - 1);
            } else {
                Task next = scheduler.poll();
                next.lastSchedule = schedules;
                schedules++;
                next.count--;
                if (next.count > 0) {
                    cooldowns.offer(next);
                }
            }
        }
        return schedules;
    }
}