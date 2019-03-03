public class Main {


    public static void main(String[] args) {
        String[] strs = new String[] {"flower","flow","flight"};
        p(new LongestCommonPrefix().longestCommonPrefix(strs));

    }

    public static void p(Object x) {
        System.out.println(x);
    }
}

