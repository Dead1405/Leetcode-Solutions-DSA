class Solution {
    public int maximumSwap(int num) {
        String s = Integer.toString(num);
        int[] max = new int[s.length()];
        int m = s.length() - 1;
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) > s.charAt(m)) m = i;
            max[i] = m;
        }
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) < s.charAt(max[i])){
                num -= s.charAt(i) * (Math.pow(10, s.length() -1 - i) - Math.pow(10, s.length() - 1 - max[i]));
                num += s.charAt(max[i]) * (Math.pow(10, s.length() -1 - i) - Math.pow(10, s.length() - 1 - max[i]));
                break;
            }
        }
        return num;
    } 
}