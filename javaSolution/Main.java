import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {


    public static void main(String[] args) {
        List<List<String>> e = new ArrayList<>();
        e.add(Arrays.asList("Gabe","Gabe0@m.co","Gabe3@m.co","Gabe2@m.co"));
        e.add(Arrays.asList("Gabe","Gabe3@m.co","Gabe4@m.co","Gabe2@m.co"));

        p(new AccountsMerge().accountsMerge(e));

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