class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
               if (strs == null || strs.length == 0) {
            // Return an empty list container rather than null
            return new ArrayList<>();
        }
        
        // Optimization: Pre-size the map to prevent resizing overhead
        int initialCapacity = (int) Math.ceil(strs.length / 0.75) + 1;
        Map<String, List<String>> anagramMap = new HashMap<>(initialCapacity);
        
        // Reusable array buffer to minimize heap allocations inside the loop
        int[] countBuffer = new int[26];
        StringBuilder keyBuilder = new StringBuilder();
        
        for (String str : strs) {
            // Step 1: Clear the reusable count buffer (O(1) operation)
            java.util.Arrays.fill(countBuffer, 0);
            
            // Step 2: Compute character frequencies for the current string
            int strLen = str.length();
            for (int i = 0; i < strLen; i++) {
                countBuffer[str.charAt(i) - 'a']++;
            }
            
            // Step 3: Build a deterministic key (e.g., "1#0#2#...#0#")
            keyBuilder.setLength(0); // Efficiently resets the StringBuilder index
            for (int count : countBuffer) {
                keyBuilder.append(count).append('#'); 
            }
            String key = keyBuilder.toString();
            
            // Step 4: Group strings by their generated key
            // computeIfAbsent is faster and cleaner than getOrDefault checks
            anagramMap.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        
        // The values of our map directly contain our grouped sublists
        return new ArrayList<>(anagramMap.values()); 
    }
}
