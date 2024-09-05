class Solution {
public:
    vector<int> missingRolls(vector<int>& rolls, int mean, int n) {
        int left = ((rolls.size()+n)*mean) - accumulate(rolls.begin(),rolls.end(),0);
        if(left > 6*n || left < n) return {};
        vector<int> ans(n,1);
        for(int i = 0; i < (left-n)/5;i++){
            ans[i] = 6;
        }
        ans[n-1] += (left-n)%5;
        return ans;
    }
};