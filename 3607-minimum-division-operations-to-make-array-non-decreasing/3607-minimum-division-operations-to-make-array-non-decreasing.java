class Solution {
    int maxDiv(int num){
        for(int i = 2; i < num; i++){
            if(num % i == 0) return num/i;
        }
        return 1;
    }
    public int minOperations(int[] nums) {
        int operation = 0;
        HashMap <Integer, Integer> memo = new HashMap<>();
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] <= nums[i + 1]) continue;
            while(nums[i] > nums[i + 1]){
                if(!memo.containsKey(nums[i])){
                    memo.put(nums[i], maxDiv(nums[i]));
                    System.out.println(maxDiv(nums[i]));
                }
                if(memo.get(nums[i]) == 1) return -1;
                nums[i] /= memo.get(nums[i]);
                operation++;
            }
        }
        return operation;
    }
}
//should have read carefully and done greedy
