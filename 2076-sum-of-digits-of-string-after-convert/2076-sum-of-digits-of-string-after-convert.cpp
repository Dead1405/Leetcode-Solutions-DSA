class Solution {
public:
    int getLucky(string s, int k) {
        long long int ans =0;
        for(char a:s){
            ans +=( a-'a'+1)%10 + (a-'a'+1)/10;
        }
        for(int i =1;i<k;i++){
            int temp = ans;
            ans = 0;
            while(temp >0){
                ans += temp % 10;
                temp /= 10;
            }
        }
        return ans;
    }
};