class Solution {
    public long minimumSteps(String s) {
        long count = 0;
        for(char c: s.toCharArray()){
            if(c == '0') count++;
        }
        long ans = 0;
        for(int i = 0; i < s.length(); i++){
            if(i < count && s.charAt(i) == '1') ans += count - i;
            else if (i >= count && s.charAt(i) == '0') ans += i - count;
        }
        return ans;
    }
}