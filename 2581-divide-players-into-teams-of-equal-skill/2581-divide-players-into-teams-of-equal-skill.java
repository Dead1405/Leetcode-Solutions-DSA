class Solution {
    public long dividePlayers(int[] skill) {
        //store counts in hashtable get max and min then run the loop for half the length
        long chem = 0;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int[] count = new int[1001];
        for(int i : skill){
            if(i > max) max = i;
            if(i < min) min = i;
            //store count in map
            count[i] += 1;
        }
        for(int i = 0; i < skill.length ; i++){
            if(count[skill[i]] < 1) continue;
            if(count[max + min - skill[i]] < 1) return -1;
            chem += (max + min - skill[i]) * skill[i];
            count[skill[i]]--;
            count[max + min - skill[i]]--;
        }
        return chem;
    }
}