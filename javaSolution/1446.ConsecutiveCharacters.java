// find # of same consecutive letters
class ConsecutiveCharacters {
    public int maxPower(String s) {
        if (s.length() == 0) return 0;
        int max = 1;
        int count = 1;
        char c = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            } else {
                count = 1;
                c = s.charAt(i);
            }
            max = Math.max(count, max);
        }
        return max;
    }
}