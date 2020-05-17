class IntegerToEnglishWords {
    private String[] TO_TWENTY = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private String[] TO_HUNDRED = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private String[] THOUSANDS = new String[]{"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        int num_thousand = 0;
        String res = "";
        while (num > 0) {
            int cur = num % 1000;
            num /= 1000;
            if (cur != 0) {
                res = translateThree(cur).trim() + " " + THOUSANDS[num_thousand++] + " " + res;
            }
        }

        return res.trim();
    }

    private String translateThree(int num) {
        assert num < 1000;
        if (num < 20) {
            return TO_TWENTY[num];
        } else if (num < 100) {
            return TO_HUNDRED[num / 10] + " " + translateThree(num % 10);
        } else {
            return TO_TWENTY[num / 100] + " Hundred " +  translateThree(num % 100);
        }
    }
}