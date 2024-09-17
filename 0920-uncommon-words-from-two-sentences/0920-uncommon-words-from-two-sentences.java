class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] words = (s1 + " " + s2).split(" ");
        HashMap<String, Integer> ans = new HashMap<>();
        for (String i : words) {
            if (ans.containsKey(i))
                ans.put(i, ans.get(i) + 1);
            else
                ans.put(i, 1);
        }
        ArrayList<String> temp = new ArrayList<>();
        for(String i : ans.keySet()){
            if(ans.get(i) == 1) temp.add(i);
        }
        String[] ans1 = temp.toArray(new String[0]);
        return ans1;
    }
}