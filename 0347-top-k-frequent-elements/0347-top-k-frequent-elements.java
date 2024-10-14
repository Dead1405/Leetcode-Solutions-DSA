class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i : nums){
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        //updating is hard in priorty Queue
        //i can use sorted indices
        mp.forEach((h ,v) -> pq.add(new int[] {h ,v}));
        for(int i = 0; i < k; i++){
            ans[i] = pq.poll()[0];
        }
        return ans;
    }
}