import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {


    public static void main(String[] args) {
        RandomizedSet r = new RandomizedSet();
        r.insert(0);
        r.insert(1);
        r.remove(0);
        r.insert(2);
        r.remove(1);
        p(r.getRandom());

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