class Solution {
    public boolean hasDuplicate(int[] nums) {
         // Sort the array: O(n log n) time
        Arrays.sort(nums); 
        
        // Check adjacent elements: O(n) time
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}