class Solution {
    public int trap(int[] height) {
        //amount of rainwater at each index is equal to modulus(height[i] - min(max height from left, max height from right))
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int max = 0;
        //fill from left
        for(int i = 0; i < height.length; i++){
            leftMax[i] = max;
            if(height[i] > max) max = height[i];
        }
        //fill from right
        max = 0;
        for(int i = height.length - 1; i >= 0; i--){
            rightMax[i] = max;
            if(height[i] > max) max = height[i];
        }
        //calc water
        int total = 0;
        int water;
        for(int i = 0; i < height.length; i++){
            water = Math.max(0 , (Math.min(leftMax[i], rightMax[i]) - height[i]));
            total += water;
        }
        return total;
    }
}