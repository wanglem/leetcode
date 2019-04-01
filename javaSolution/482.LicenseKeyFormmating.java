
// Google
/*
    tricky. reset count back to 1 after inserting dash, because after resetting you are inserting char again.
 */
class LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = S.length()-1; i >= 0; i--) {
            char c = S.charAt(i);
            if (c != '-') {
                if (count++ == K) {
                    sb.append('-');
                    count =  1;
                }
                sb.append(Character.toUpperCase(c));
            }
        }
        return sb.reverse().toString();
    }
}