class Solution {
public:
    int maxProfit(std::vector<int>& prices) {
        int profit = 0;
        int n = prices.size();
        if (n == 0) return 0;

        std::vector<int> minarr(n, 0);
        std::vector<int> maxarr(n, 0);

        // Lambda function to calculate minarr
        auto calculateMinArr = [&]() {
            int min = prices.front();
            for (int i = 0; i < n; i++) {
                if (prices[i] < min) {
                    min = prices[i];
                }
                minarr[i] = min;
            }
        };

        // Lambda function to calculate maxarr
        auto calculateMaxArr = [&]() {
            int max = prices.back();
            for (int i = n - 1; i >= 0; i--) {
                if (prices[i] > max) {
                    max = prices[i];
                }
                maxarr[i] = max;
            }
        };

        // Create threads for each calculation
        std::thread minThread(calculateMinArr);
        std::thread maxThread(calculateMaxArr);

        // Wait for both threads to finish
        minThread.join();
        maxThread.join();

        // Calculate maximum profit
        for (int i = 0; i < n; i++) {
            if (maxarr[i] - minarr[i] > profit) {
                profit = maxarr[i] - minarr[i];
            }
        }

        return profit;
    }
};