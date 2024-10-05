class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] string1 = new int[26];
        for(char c : s1.toCharArray()){
            string1[c - 'a']++;
        }
        int sum = s1.length();
        int[] temp = new int[26];
        System.arraycopy(string1, 0, temp, 0, 26);
        //sliding window
        int front = 0, rear = 0;

        while(rear < s2.length()){
            char c = s2.charAt(rear);
            if(temp[c - 'a'] == 0){
                if(front == rear){
                    front++;
                    rear++;
                    //reset window
                    sum = s1.length();
                    System.arraycopy(string1, 0, temp, 0, 26);
                }
                else{
                    temp[s2.charAt(front) - 'a']++;
                    front++;
                    sum++;
                }

            }
            else{
                temp[c - 'a']--;
                sum--;
                if(sum == 0) return true;
                rear++;
            }
        }
        return false;
        // StringBuilder temp = new StringBuilder(s1);
        // for(char c : s2.toCharArray()){
        //     if(temp.indexOf("" + c) != -1) {
        //         temp.deleteCharAt(temp.indexOf("" + c));
        //         if(temp.length() == 0) return true;
        //     }
        //     else{
        //         //reset the temp
        //         temp.setLength(0);
        //         temp.append(s1);
        //     }
        // }
        // return false;
    }
}