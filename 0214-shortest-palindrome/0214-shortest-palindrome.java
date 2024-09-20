class Solution {
    public boolean palinCheck(String s){
        return s.equals(rev(s, 0));
    }
    public String rev(String s, int i){
        if ( i ==  s.length()){
            return "";
        }
        StringBuilder sb = new StringBuilder(s.substring(i));
        return sb.reverse().toString();
    }
    public String shortestPalindrome(String s) {
        for(int i = s.length(); i >= 1; i--){
            if(palinCheck(s.substring(0,i)) == true){
                //edge case trip
                return rev(s, i) + s;
            }
        }
        return s;
    }
}