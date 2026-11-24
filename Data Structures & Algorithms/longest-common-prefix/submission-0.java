class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minLength = Math.min(minLength, strs[i].length());
        }

        for (int i = 0; i < minLength; i++) {
            char curr = strs[0].charAt(i);
            for (int j = 0; j < n; j++) {
                if (strs[j].charAt(i) != curr) {
                    if (i == 0) {
                        return "";
                    } else {
                        return strs[j].substring(0, i);
                    }
                }
            }
        }

        return strs[0].substring(0, minLength);
    }
}