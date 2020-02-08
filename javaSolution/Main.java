import java.util.HashSet;
import java.util.Set;

public class Main {


    public static void main(String[] args) {
        int[] a = {7,2,5,10,8};
        String b = "105";
        int c = 5;
        String[] d = {"wrt","wrf","er","ett","rftt"};
        int[][] e = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        double[] f = {2.0, 3.0};
        String[][] g = new String[][] {{"a", "b"}, {"b", "c"}};
        String[][] queries = new String[][] {{"a","c"},{"b","c"},{"a","e"},{"a","a"},{"x","x"}};

    }

    private static void print2D(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }

    public static void p(Object x) {
        System.out.println(x);
    }
    public static void p(int[] x) {
        for (int i: x){
            System.out.print(i);
            System.out.print(", ");
        }
    }
    public static void p(double[] x) {
        for (double i: x){
            System.out.print(i);
            System.out.print(", ");
        }
    }
}