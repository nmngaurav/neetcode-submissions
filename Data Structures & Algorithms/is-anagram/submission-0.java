class Solution {
    public boolean isAnagram(String s, String t) {
        // Fast-fail check
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        
        // Fixed-size frequency bucket for lowercase a-z
        int[] charCounts = new int[26];
        
        // Single pass layout using two pointers or simple loop
        int length = s.length();
        for (int i = 0; i < length; i++) {
            charCounts[s.charAt(i) - 'a']++;
            charCounts[t.charAt(i) - 'a']--;
        }
        
        // If it's an anagram, all buckets must balance back to 0
        for (int count : charCounts) {
            if (count != 0) {
                return false;
            }
        }
        
        return true;
    }
}
