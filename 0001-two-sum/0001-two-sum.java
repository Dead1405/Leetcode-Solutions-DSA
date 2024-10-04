class Solution {
    public int[] twoSum(int[] nums, int target) {
        //use sorted indices 
        // Integer[] sid = new Integer[nums.length];
        // for(int i = 0; i < nums.length; i++){
        //     sid[i] = i;
        // }
        // Arrays.sort(sid, (a, b) -> Integer.compare(nums[a], nums[b]));
        // int front = 0, rear = nums.length - 1;
        // while(true){
        //     if(nums[sid[front]] + nums[sid[rear]] == target){
        //         return new int[]{sid[front], sid[rear]}; 
        //     }
        //     else if (nums[sid[front]] + nums[sid[rear]] > target) rear--;
        //     else front ++;
        // }

        //use hashmap
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < nums.length; i ++){
            if(mp.containsKey(target - nums[i])) return new int[]{mp.get(target - nums[i]), i};
            else mp.put(nums[i], i);
        }
        return new int[]{0, 0};
    }
}