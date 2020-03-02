import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {


    public static void main(String[] args) {
        p(new CampusBikeII().assignBikes(
                new int[][]{{0,0},{1,0},{2,0},{3,0},{4,0},{5,0},{6,0},{7,0},{8,0}},
                new int[][]{{0,999},{1,999},{2,999},{3,999},{4,999},{5,999},{6,999},{7,999},{8,999},{9,999}}));

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