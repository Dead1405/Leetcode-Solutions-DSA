class Solution {
    public int minSubarray(int[] nums, int p) {
        //BRUTE FORCE - generate subarrays and keep subtracting them and(include) 3 4 8 10 || 7 6 2 0(exclude)
        long sum = 0;
        for(int i : nums){
            sum += i;
        }
        if(sum % p == 0) return 0;
        long [] prefix = new long[nums.length];
        long  temp = 0;
        for(int i = 0; i < nums.length; i++){
            temp += nums[i];
            prefix[i]= temp;
        }
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j + i - 1 < nums.length; j++){
                //start = j end = j + len - 1
                temp = prefix[i-1+j] + nums[j] - prefix[j];
                if((sum - temp) % p == 0) return i;
            }
        }
        return -1;
    }
}