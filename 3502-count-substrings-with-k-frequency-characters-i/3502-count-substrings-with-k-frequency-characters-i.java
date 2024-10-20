class Solution {
    public int numberOfSubstrings(String s, int k) {
        int[] count = new int[26];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> count[b] - count[a]);
        for(int i = 0; i < 26; i++){
            pq.add(i);
        }
        int ans = 0;
        int front = 0, rear = 0;
        while(rear != s.length()){
            if(count[pq.peek()] == k){
                ans += s.length() - front + 1;
                int c = s.charAt(rear++) - 'a';
                pq.remove(c);
                count[c]--;
                pq.add(c);
            }
            else{
                if(front == s.length()) break;
                int c = s.charAt(front++) - 'a';
                pq.remove(c);
                count[c]++;
                pq.add(c);
            }
        }
        return ans;
    }
}