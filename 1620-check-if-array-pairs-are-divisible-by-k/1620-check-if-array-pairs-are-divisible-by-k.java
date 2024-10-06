class Solution {
    public boolean canArrange(int[] arr, int k) {
        // store all reminders in hashmap if counterpart is found remove count else
        // increase own count keep a track of count too
        int count = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i : arr) {
            //continue for divisible elements
            if (i % k == 0)
                continue;
            //
            int rem = (k + (i % k)) % k;
            int counter = k - rem;
            if (mp.containsKey(counter)) {
                count--;
                if (mp.get(counter) == 1) mp.remove(counter);
                else mp.put(counter, mp.get(counter) - 1);
            } 
            else {
                count++;
                mp.put(rem, mp.getOrDefault(rem, 0) + 1);
            }
            System.out.println("" + count +" "+ rem +" "+ counter);
        }
        return count == 0;
    }
}