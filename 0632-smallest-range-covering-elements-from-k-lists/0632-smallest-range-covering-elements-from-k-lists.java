class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] range = new int[2]; range[0] = Integer.MIN_VALUE; range[1] = Integer.MAX_VALUE;
        int[] pointers = new int[nums.size()];

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) ->
            nums.get(a).get(pointers[a]) - nums.get(b).get(pointers[b])
        );
        int max = nums.get(0).get(0);
        for(int i = 0; i < nums.size(); i++){
            pq.add(i);
            if(max < nums.get(i).get(0)) max = nums.get(i).get(0);
        }

        int least, min;
        while(pq.size() == nums.size()){
            least = pq.poll();
            min = nums.get(least).get(pointers[least]);
        
            if(Math.abs(range[1] + 0L - range[0]) > Math.abs(max - min) || (Math.abs(range[1] - range[0]) == Math.abs(max - min)) && range[0] > min){
                range[1] = max;
                range[0] = min;
            }

            if(range[1] == range[0]) return range;

            pointers[least]++;
            if(pointers[least] < nums.get(least).size()){ pq.add(least);
            if(max < nums.get(least).get(pointers[least])) max = nums.get(least).get(pointers[least]);}
        }
        return range;
    }
}