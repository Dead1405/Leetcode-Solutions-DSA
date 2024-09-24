class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie root = new Trie();
        int ans = 0;
        //make trie with arr1
        for (int i : arr1){
            root.insert(Integer.toString(i));
        }
        //serch for largest common prefix using trie
        for(int i : arr2){
            int temp = root.matcher(Integer.toString(i));
            if (temp > ans) ans = temp;
        } 
        return ans;
    }
}

class Trie{
    Trie[] alphabets = new Trie[10];
    //insertion in trie
    public void insert(String s){
        Trie temp = this;
        for(int i = 0; i < s.length(); i++){
            int word = s.charAt(i) - '0';
            if(temp.alphabets[word] == null){
                temp.alphabets[word] = new Trie();
                temp = temp.alphabets[word];
            }
            else{
                temp = temp.alphabets[word];
            }
        }
    }

    //searching in trie
    public int matcher(String s){
        Trie temp = this;
        int matchlen = 0;
        for(int i = 0; i < s.length(); i++){
            int word = s.charAt(i) - '0';
            if(temp.alphabets[word] == null){
                return matchlen;
            }
            else{
                matchlen++;
                temp = temp.alphabets[word];
            }
        }
        return matchlen;
    }
}