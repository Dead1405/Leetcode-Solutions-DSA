class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int profit = 0;
        int max = 0;
        for(int i = 0; i < prices.length; i++){
            profit = prices[i] - buy;
            if(profit > max) max = profit;
            if(buy > prices[i]) buy = prices[i];
        }
        return max;
    }
}