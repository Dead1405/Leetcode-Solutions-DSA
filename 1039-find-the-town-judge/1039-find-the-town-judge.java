class Solution {
    public int findJudge(int n, int[][] trust) {
        //make two arrays 1) trust and 2) trsuted by
        int[] trusts = new int[n];
        int[] trusted =  new int[n];

        for (int i = 0; i < trust.length; i++){
            trusts[trust[i][0]-1]++;
            trusted[trust[i][1]-1]++;
        }

        int found = -1;
        for(int i = 0; i < n; i++){
            if (trusts[i] == 0 && trusted[i] == n-1) return i+1;
        }
        return -1;
        // int found = -1;
        // //look for an empty array (judge) in adjoincy list
        // for(int i = 0; i < trust.length; i++){
        //     if(trust[i].length == 0){
        //         if (found == -1) found = i;
        //         // if two empty lists found return false
        //         else return -1;
        //     }
        // }
        // if (found == -1) return -1;
        // //check if judge is present in each adjoincy list except itself
        // for(int i = 0; i < trust.length; i++){
        //     boolean present = false;
        //     if (i == found) continue;
        //     for (int j = 0; j < trust[i].length; i++){
        //         if (trust[i][j] == found ){
        //             present = true;
        //             break;
        //         }
        //     }
        //     if(present == false) return -1;
        // }
        // return found;
    }
}