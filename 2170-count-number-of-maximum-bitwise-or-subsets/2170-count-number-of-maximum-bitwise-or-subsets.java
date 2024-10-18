class Solution {
    //max [0] = maximum
    //max[1] = count
    public void helper(int curr, int i, int[] nums, int[] max){
        if(i == nums.length){
            if(curr == max[0]) max[1]++;
            else if( curr > max[0]){
                max[1] = 1;
                max[0] = curr;
            }
        }
        else{
            helper(curr | nums[i], i + 1, nums, max);
            helper(curr, i + 1, nums, max);
        }
    }
    public int countMaxOrSubsets(int[] nums) {
        int[] max = new int[]{0, 0};
        helper(0, 0, nums, max);
        return max[1];
    }
}