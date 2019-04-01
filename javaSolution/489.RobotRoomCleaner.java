import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
    1. always turn robot to right.
    2. after 3 times (first time go up), the DFS direction should be ordered by up, right, down, left
    Something like:
               1(up)
               |
4(3rd right) - 0 - 2 (1st right)
               |
               3 (2nd right)
 */
class RobotRoomCleaner {
    //                                          up     right    down   left
    private int[][] directions = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public void cleanRoom(Robot robot) {
        Map<Integer, Set<Integer>> visited = new HashMap<>();
        visit(robot, visited, 0, 0, 0);
    }

    private void visit(Robot robot, Map<Integer, Set<Integer>> visited, int row, int col, int towards) {
        if (!visited.containsKey(row)) {
            visited.put(row, new HashSet<>());
        }
        visited.get(row).add(col);
        robot.clean();
        for (int i = 0; i < 4;i++) {
            int newTowards = (i+towards)%4;
            int nextRow = row + directions[newTowards][0];
            int nextCol = col + directions[newTowards][1];
            if (!(visited.containsKey(nextRow) && visited.get(nextRow).contains(nextCol)) && robot.move()) {
                visit(robot, visited, nextRow, nextCol, newTowards);
                goBack(robot);
            }
            robot.turnRight();
        }
    }

    private void goBack(Robot robot) {
        robot.turnLeft();
        robot.turnLeft();
        robot.move();
        robot.turnLeft();
        robot.turnLeft();
    }
}

class Robot {
    public boolean move(){return false;}
    public void turnLeft(){}
    public void turnRight(){}
    public void clean(){}
}