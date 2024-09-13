class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int currXor = 0;
        //prefix sum
        for(int i = 0; i < arr.length; i++){
            currXor ^= arr[i];
            arr[i] = currXor;
        }
        int[] ans = new int[queries.length];
        for(int i = 0; i < ans.length; i++){
            if(queries[i][0] == 0) ans[i] = arr[queries[i][1]];
            else ans[i] = arr[queries[i][0]-1]^arr[queries[i][1]];
        }
        return ans;
    }
}