class Solution {
    public boolean areSentencesSimilar(String s1, String s2) {
        String[] word1 = s1.split(" ");
        String[] word2 = s2.split(" ");
        //keep the larger array in words 2
        String[] words1, words2;
        if(word1.length > word2.length){
            words1 = word2;
            words2 = word1;
        }
        else{
            words1 = word1;
            words2 = word2;
        }
        //use 2 ppointers in both
        int start1 = 0, start2 = 0, e1 = words1.length - 1, e2 = words2.length - 1;
        while(start1 <= e1 && words1[start1].equals(words2[start1])){
            start1++;
        }
        if(start1 > e1) return true;
        while(e1 >= start1 && words1[e1].equals(words2[e2])){
            e1--;
            e2--;
        }
        if(e1 < start1) return true;
        else return false;
    }
}
