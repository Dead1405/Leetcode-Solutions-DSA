class Solution {
    public int minAddToMakeValid(String s) {
        int add = 0;
        int open = 0;
        for(char c : s.toCharArray()){
            if(c == '(') open++;
            else{
                if(open <= 0) add++;
                else open--;
            }
        }
        return add + open;
    }
}