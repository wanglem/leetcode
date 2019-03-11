class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        char[] schar = s.toCharArray();
        while (i < j) {
            while (i <= j && !Character.isLetterOrDigit(schar[i])) i++;
            while (i <= j && !Character.isLetterOrDigit(schar[j])) j--;
            if (i <= j && Character.toLowerCase(schar[i]) != Character.toLowerCase(schar[j])) {
                return false;
            }
            i ++;
            j --;
        }
        return true;
    }
}