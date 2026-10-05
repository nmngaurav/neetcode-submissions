class Solution {
    public int[] topKFrequent(int[] nums, int k) {
                // Step 1: Count how many times each number appears
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create a Min-Heap. 
        // We configure it to compare elements based on their frequencies in our map.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(countMap.get(a), countMap.get(b))
        );

        // Step 3: Keep only the top 'k' most frequent elements in the heap
        for (int num : countMap.keySet()) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // Evict the least frequent element if size exceeds k
            }
        }

        // Step 4: Extract the elements out of the heap into our final array
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }

        return result;
    }
}
