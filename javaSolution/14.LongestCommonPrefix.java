class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String commonPrefix = "";
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)) {
                    return commonPrefix;
                }
            }
            commonPrefix += strs[0].substring(i, i+1);
        }
        return commonPrefix;
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        String head = strs[0];
        if (strs.length == 1) return head;
        if (head.length() < 1) return "";
        for (int i = 0; i < head.length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i || head.charAt(i) != strs[j].charAt(i)) {
                    return head.substring(0, i);
                }
            }
        }
        return head;
    }
}