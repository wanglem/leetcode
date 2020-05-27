class NumberofStudentsDoingHomeworkataGivenTime {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int numStudents = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (queryTime >= startTime[i] && queryTime<= endTime[i]) numStudents++;
        }
        return numStudents;
    }
}