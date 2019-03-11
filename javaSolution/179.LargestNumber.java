import java.util.Arrays;
import java.util.Comparator;

class LargestNumber {
    private class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return (o2 + o1).compareTo(o1 + o2);
        }
    }
    public String largestNumber(int[] nums) {
        String[] toStrs = new String[nums.length];
        for (int i = 0; i<nums.length; i++) {
            toStrs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(toStrs, new LargerNumberComparator());
        if (toStrs[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String st : toStrs) {
            sb.append(st);
        }
        return sb.toString();
    }
}