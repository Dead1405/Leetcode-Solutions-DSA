class Solution {
    public long dividePlayers(int[] skill) {
        //sort then use 2 pointers if sum of those two pointers != prev return -1 
        Arrays.sort(skill);
        int start = 0, end = skill.length - 1;
        long chem = 0;
        int skilled = skill[skill.length - 1] + skill[0];
        while(start < end){
            if(skill[start] +skill[end] != skilled) return -1;
            chem += skill[start] * skill[end];
            start++;
            end--;
        }
        return chem;
    }
}