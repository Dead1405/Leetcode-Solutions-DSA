class Solution {
public:
    vector<int> xorQueries(vector<int>& arr, vector<vector<int>>& queries) {
        int currxor = 0;
        vector<int> ans;
        for(int & i:arr){
            currxor = currxor^i;
            i = currxor;
        }
        for(int i = 0; i < queries.size(); i++){
            int start = queries[i][0];
            int end = queries[i][1];
            if (start == 0) ans.push_back(arr[end]);
            else ans.push_back(arr[end]^arr[start-1]);
        }
        return ans;
    }
};