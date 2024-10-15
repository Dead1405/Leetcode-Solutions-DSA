class Solution {
    public long minimumSteps(String s) {
        long count = 0;
        long ans = 0;
        for(char c: s.toCharArray()){
            if(c == '1') count++;
            else ans += count;
        }
        return ans;
    }
}