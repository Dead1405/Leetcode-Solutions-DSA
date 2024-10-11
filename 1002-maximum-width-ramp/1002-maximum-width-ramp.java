class Solution {
    int binSearch(Stack<Integer> stack, int[] nums, int key){
        int smaller = -1;
        int start = 0, end = stack.size() - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[stack.get(mid)] == key) return stack.get(mid);
            else if (nums[stack.get(mid)] < key){
                smaller = stack.get(mid);
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        if(smaller == -1) return -1;
        return smaller;
    }
    public int maxWidthRamp(int[] nums) {
        int maxWidth = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i = 1; i < nums.length; i++){
            int smaller = binSearch(stack, nums, nums[i]);
            if(smaller != -1 && (i - smaller > maxWidth)) maxWidth = i - smaller;
            if(nums[stack.peek()] > nums[i])stack.push(i);
        }
        return maxWidth;
    }
}