class Solution {
    public boolean isAnagram(String s, String t) {
        int s_size = s.length();
        int t_size = t.length();

        if (s_size != t_size) return false;

        int[] freq = new int[26];
        for (int i = 0; i < s_size; i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for (int char_freq : freq) {
            if (char_freq != 0) {
                return false;
            }
        }

        return true;
    }
}
