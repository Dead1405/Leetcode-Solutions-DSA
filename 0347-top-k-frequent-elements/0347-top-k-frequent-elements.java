class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i : nums){
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }
        // PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        // //updating is hard in priorty Queue
        // //i can use sorted indices
        // mp.forEach((h ,v) -> pq.add(new int[] {h ,v}));
        // for(int i = 0; i < k; i++){
        //     ans[i] = pq.poll()[0];
        // }
        int[][] count = new int[nums.length][2];
        Iterator it = mp.entrySet().iterator();
        int i = 0;
        while(it.hasNext()){
            Map.Entry e = (Map.Entry) it.next();
            count[i++] = new int[] {(int)e.getKey(), (int)e.getValue()};
        }
        Arrays.sort(count, (a, b) -> b[1] - a[1]);
        for(i = 0; i < k; i++){
            ans[i] = count[i][0];
        }
        return ans;
    }
}