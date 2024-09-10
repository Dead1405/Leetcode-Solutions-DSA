class Solution {
    public int reverse(int x) {
        StringBuilder str = new StringBuilder(Integer.toString(Math.abs(x)));
        int pos = x>=0 ? 1:-1;
        try{
            return pos*Integer.parseInt(str.reverse().toString());
        }
        catch(Exception e){
            return 0;
        }

    }
}