class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        int ans = 0;
        int highest = *max_element(nums.begin(),nums.end());
        int longest = 0;
        int And = highest;
        for(int i = 0; i < nums.size(); i++){
            And &= nums[i];
            if(And == highest){
                longest++;
                if(longest > ans) ans = longest;
            }
            else{
                longest = 0;
                And = highest;
            }
        }
        return ans;
    }
};