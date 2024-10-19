class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> mp = new HashMap<>();
        for(int i = 0; i < 26; i++){
            mp.put(order.charAt(i), i);
        }
        for(int i = 0; i < words.length - 1; i++){
            for(int j = 0; j < words[i].length(); j++){
                if(j >= words[i + 1].length()) return false;
                if(words[i].charAt(j) != words[i+ 1].charAt(j)){
                    if(mp.get(words[i].charAt(j)) > mp.get(words[i + 1].charAt(j))) return false;
                    break;
                }
            }

        }
        return true;
    }
}