class Solution {
    public char findKthBit(int n, int k) {
        if(n == 1 || k == 1) return '0';
        int len = 0;
        for(int i = 0; i < n; i++) len = len * 2 + 1;
        int flip = 0;
        while(true){
            if(len == 1) return (char)(0^flip + '0');
            if(k == (len + 1) / 2){
                return (char)(1^flip + '0');
            }
            else if (k > (len + 1) / 2){
                flip ^= 1;
                k = len - k + 1;
            }
            System.out.println(len);
            len /= 2;
            
        }
    }
}