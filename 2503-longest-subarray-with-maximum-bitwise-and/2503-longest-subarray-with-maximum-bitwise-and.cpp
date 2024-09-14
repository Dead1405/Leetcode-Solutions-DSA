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

static const int KDS = []() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    std::cout.tie(nullptr);
    return 0;
}();