class Solution {
    public int minSwaps(String s) {
        int openCount = 0, swaps = 0;

        // Traverse the string
        for (char c : s.toCharArray()) {
            if (c == '[') {
                openCount++;  // Increment open bracket count
            } else {
                if (openCount > 0) {
                    openCount--;  // Close a matched pair
                } else {
                    swaps++;      // Unmatched closing bracket, requires a swap
                    openCount++;  // Account for the incoming open bracket after swap
                }
            }
        }

        return swaps;
    }
}