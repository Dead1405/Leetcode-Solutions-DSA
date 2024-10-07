class Solution {
public:
    int minLength(string s) {
        //same keep 2 pointers 
        int top = -1;
        for(int i = 0; i < s.size(); i++){
            if(top == -1){//empty stack
                s[++top] = s[i]; 
            }
            else if (s[top] == 'A' && s[i] == 'B' || s[top] == 'C' && s[i] == 'D'){
                top--;
            }
            else{
                s[++top] = s[i];
            }
        }
        return top + 1;
    }
};

auto init = []() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    return 'c';
}();