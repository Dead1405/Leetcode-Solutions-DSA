class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int ans = 0;
        HashSet <Character> all = new HashSet<>();
        int len = allowed.length();
        for(int i = 0; i < len; i++) {
            all.add(allowed.charAt(i));
        }
        for(String str:words){
            boolean valid = true;
            len = str.length();
            for(int j = 0; j<len; j++){
                char i = str.charAt(j);
                if(all.contains(i) ==  false) {
                    valid = false;
                    break;
                }
            }
            if(valid) ans++;
        }
        return ans;
    }
}