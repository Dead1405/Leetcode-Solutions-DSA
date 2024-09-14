class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        int high = *max_element(nums.begin(), nums.end());
        int ans  = 0;
        int streak = 0;
        for(int i = 0; i < nums.size(); i++){
            if(nums[i] == high){
                streak++;
                if(streak> ans) ans = streak;
            }
            else streak = 0;
        }
        return ans;
    }
};