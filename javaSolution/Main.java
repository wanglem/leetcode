public class Main {


    public static void main(String[] args) {
        int[] strs = new int[] {2,3,6,7};
        p(new CombinationSum().combinationSum(strs, 7));

    }

    public static void p(Object x) {
        System.out.println(x);
    }
}