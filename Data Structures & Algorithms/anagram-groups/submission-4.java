class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Base safety check
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        // Map to store: Key (Sorted String) -> Value (List of matching original strings)
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // Convert string to character array and sort it
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedKey = new String(charArray); // E.g., "cat" and "act" both become "act"

            // If the key doesn't exist, create a new list. Then add the original string.
            map.computeIfAbsent(sortedKey, k -> new ArrayList<>()).add(str);
        }

        // Return all grouped lists
        return new ArrayList<>(map.values());
    }
}
