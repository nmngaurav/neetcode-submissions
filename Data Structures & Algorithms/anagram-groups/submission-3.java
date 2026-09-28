class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // Array to count frequencies of letters a to z
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }

            // Convert the frequency array into a unique string key
            StringBuilder sb = new StringBuilder();
            for (int val : count) {
                sb.append(val).append('#'); // Using '#' as a separator
            }
            String key = sb.toString();

            // Group them
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
