import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class IntegerToEnglishWords {
    private String[] TO_TWENTY = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private String[] TO_HUNDRED = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private String[] THOUSANDS = new String[]{"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        LinkedList<String> words = new LinkedList<>();
        if ( num == 0 ) return "Zero";
        int count = 0;
        while (num > 0) {
            int remainder = num % 1000;
            num /= 1000;
            LinkedList<String> three = convertThreeDigit(remainder);
            if (three.size() > 0 && count > 0) {
                three.add(THOUSANDS[count]);
            }
            count++;
            three.addAll(words);
            words = three;
        }

        return String.join(" ", words);
    }

    private LinkedList<String> convertThreeDigit(int n) {
        LinkedList<String> res = new LinkedList<>();
        if (n == 0) {
            return res;
        }
        if ( n < 20 ) {
            res.add(TO_TWENTY[n]);
        } else if (n < 100) {
            res.add(TO_HUNDRED[n / 10]);
            res.addAll(convertThreeDigit(n % 10));
        } else {
            res.add(TO_TWENTY[n / 100]);
            res.add("Hundred");
            res.addAll(convertThreeDigit(n % 100));
        }
        return res;
    }
}