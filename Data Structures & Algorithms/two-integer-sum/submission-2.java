class Solution {
        public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[]{-1, -1};
        }
        
        // Step 1: Create a 2D array tracking [Value, Original Index]
        int n = nums.length;
        int[][] mappedNums = new int[n][2];
        for (int i = 0; i < n; i++) {
            mappedNums[i][0] = nums[i]; // Value
            mappedNums[i][1] = i;       // Original Index
        }
        
        // Step 2: Sort the array based on values (O(n log n))
        // This ensures the pointers always work in standard Ascending mode
        Arrays.sort(mappedNums, Comparator.comparingInt(a -> a[0]));
        
        // Step 3: Run the classic Ascending Two-Pointer scan
        int left = 0;
        int right = n - 1;
        
        while (left < right) {
            int currentSum = mappedNums[left][0] + mappedNums[right][0];
            
            if (currentSum == target) {
                // Recover the original unsorted indices
                int index1 = mappedNums[left][1];
                int index2 = mappedNums[right][1];
                
                // Return with the smaller index first as requested
                return index1 < index2 ? new int[]{index1, index2} : new int[]{index2, index1};
            } else if (currentSum < target) {
                left++; // Sum is too small, move to a larger value
            } else {
                right--; // Sum is too large, move to a smaller value
            }
        }
        
        return new int[]{-1, -1};
    }
}
