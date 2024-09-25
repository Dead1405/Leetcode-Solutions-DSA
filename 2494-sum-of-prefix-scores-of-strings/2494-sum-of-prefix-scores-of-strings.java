class Solution {
    public int[] sumPrefixScores(String[] words) {
        //trie with customization of count     
        Trie tree = new Trie();
        for(String s : words){
            tree.insert(s);
        }
        int[] ans = new int[words.length];
        for(int i = 0; i < ans.length; i++){
            ans[i] = tree.preMatcher(words[i]);
        }
        return ans;
    }
}
class Trie{
    int count = 1;
    Trie[] children = new Trie[26];

    public void insert(String s){
        Trie temp = this;
        for(int i = 0; i < s.length(); i++){
            if(temp.children[s.charAt(i) - 'a'] == null) temp.children[s.charAt(i) - 'a'] = new Trie();
            else temp.children[s.charAt(i) - 'a'].count++;
            temp = temp.children[s.charAt(i) - 'a'];
        }
    }

    public int preMatcher(String s){
        Trie temp = this;
        int match = 0;
        for(int i = 0; i < s.length(); i++){
            match += temp.children[s.charAt(i) - 'a'].count;
            temp = temp.children[s.charAt(i) - 'a'];
        }
        return match;
    }
}

//approach 1 using hashmap to store count of each prefix 
// class Solution {
//     public int[] sumPrefixScores(String[] words) {
//         //make map kinda put each prefix an then calc?
//         HashMap <String, Integer> mp = new HashMap<>();
//         for(String s : words){
//             for(int i = 1; i <= s.length(); i++){
//                 mp.put(s.substring(0, i), mp.getOrDefault(s.substring(0, i), 0) + 1);
//             }
//         }
//         int[] ans = new int[words.length];
//         //put each value from map to array
//         for(int i = 0; i < ans.length; i ++){
//             String word = words[i];
//             for(int j = 1; j <= word.length(); j++){
//                 ans[i] += mp.get(word.substring(0, j));
//             }
//         }

//         return ans;
//     }
// }