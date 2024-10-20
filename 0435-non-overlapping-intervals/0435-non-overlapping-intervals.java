class Solution {
    public int eraseOverlapIntervals(int[][] nums) {
        Arrays.sort(nums, (a, b) -> a[1] - b[1]);
        int deletions = 0;
        int end = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i][0] < end) deletions++;
            else end = nums[i][1];
        }
        return deletions;
    }
}