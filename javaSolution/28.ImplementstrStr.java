class ImplementstrStr {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int i = 0;
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(0) && haystack.length() - i - 1 >= needle.length()) {
                int j = 1;
                while (j < needle.length() && haystack.charAt(i+j) == needle.charAt(j)) {
                    j++;
                }
                if (j == needle.length()) {
                    return i;
                }
            }
            i++;
        }
        return -1;
    }
}