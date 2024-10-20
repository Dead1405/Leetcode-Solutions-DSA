class Solution {
    public int lc(int i, int j, String s1, String s2, int[][] dp){  
        if(i <0 || j < 0) return 0;
        if(dp[i][j] == -1){
            int value;
            if(s1.charAt(i) == s2.charAt(j)) value = 1 + lc(i-1, j-1, s1, s2, dp);
            else value = Math.max(lc(i, j - 1, s1, s2, dp), lc(i-1, j, s1, s2, dp));
            dp[i][j] = value;
        }
        return dp[i][j];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int[] row : dp) Arrays.fill(row, -1);
        return lc(text1.length() -1, text2.length() - 1, text1, text2, dp);
    }
}