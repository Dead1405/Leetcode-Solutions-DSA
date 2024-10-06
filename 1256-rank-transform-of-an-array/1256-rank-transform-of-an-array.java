class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0) return new int[0];
        Integer[] sid = new Integer[arr.length];
        for(int i = 0; i < arr.length; i++){
            sid[i] = i;
        }
        Arrays.sort(sid, (a, b) -> Integer.compare(arr[a], arr[b]));
        int[] rank = new int[arr.length];
        int prev = arr[sid[0]];
        rank[sid[0]] = 1;
        int r = 1;
        for(int i = 1; i < arr.length; i++){
            if(arr[sid[i]] != prev){
                prev = arr[sid[i]];
                r++;
            }
            rank[sid[i]] = r;
        }
        return rank;
    }
}