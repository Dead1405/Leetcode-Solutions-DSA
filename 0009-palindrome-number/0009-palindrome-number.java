class Solution {
    public boolean isPalindrome(int x) {
        StringBuilder str = new StringBuilder(Integer.toString(x));
        return Integer.toString(x).equals(str.reverse().toString()); 
    }
}