class Solution {
    public int minSwaps(String s) {
        //at any number of time amount of open brackets must not exceed amount of closed ones if we tread from forward
        //same goes for opening brackets if we tread from backwards
        //if i am treading and i encounter a faulty parenthesis i will swap it with one from after but i will need to keep a track of where i have stored it
        //in order to minimize number of swaps i should replace the ones that definitely need to be replaced
        //i will be using 2 pointers
        int swaps = 0;
        int front = 0;
        int rear = s.length() - 1;
        StringBuilder s1 = new StringBuilder(s);
        int openCount1 = 0, openCount2 = 0, closeCount1 = 0, closeCount2  = 0;
        while(front < rear){
            //detect first wrong
            while(front < rear){
                if(s1.charAt(front) == '['){
                    openCount1++;
                }
                else{
                    closeCount1++;
                }
                if(openCount1 < closeCount1) break;
                else front++;
            }
            //find faulty from behind
            while(front < rear){
                if(s1.charAt(rear) == '['){
                    openCount2++;
                }
                else{
                    closeCount2++;
                }
                if(openCount2 > closeCount2) break;
                else rear--;
            }
            if(front < rear){
                char c = s1.charAt(front);
                s1.setCharAt(front, s1.charAt(rear));
                s1.setCharAt(rear, c);
                swaps++;
                closeCount1--;
                openCount2--;
            }
            else return swaps;
        }
        return 0;
    }
}