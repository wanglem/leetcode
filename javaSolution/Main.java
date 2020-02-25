import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {


    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9};
//        p(new OptimalAccountBalancing().minTransfers(new int[][]{{0,1,1},{0,2,1},{1,3,1},{2,3,1}}));
//        p(new OptimalAccountBalancing().minTransfers(new int[][]{{0,1,10}, {1,0,1}, {1,2,5}, {2,0,5}}));
        p(new OptimalAccountBalancing().minTransfers(new int[][]{{0,1,2}, {1,2,1}, {1,3,1}}));
    }
    private static void aa(int a) {
        p(a);
    }

    private static void p(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
    private static void p(int[][] board) {
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