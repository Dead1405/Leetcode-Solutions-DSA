class Solution {
    public int minGroups(int[][] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int max = 0;
        int groups = 0;
        int i = 0, j = 0;
        while(i < intervals.length){
            if(start[i] <= end[j]){
                i++;
                groups++;
                if(groups > max) max = groups;
            }
            else{
                j++;
                groups--;
            }
        }
        return max;
        //still slow brrrr
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // Arrays.sort(intervals, (a, b) -> { return a[0] - b[0]; });
        // for(int[] i : intervals){
        //     if(pq.isEmpty() || pq.peek() < i[0]){
        //         pq.poll();
        //     }
        //     pq.add(i[1]);
        // }
        // return pq.size();

        //sort them to decrease time complexity
        // Arrays.sort(intervals, (a, b) -> { return a[0] - b[0]; });
        // ArrayList<Integer> sets =new ArrayList<>();
        // for(int[] i : intervals){
        //     int found = 0;
        //     for(int j = 0; j < sets.size(); j++){
        //         //start is after the end of set
        //         if(sets.get(j) < i[0]){
        //             sets.set(j, i[1]);
        //             found = 1;
        //             break;    
        //         }
        //     }
        //     if(found == 0) sets.add(i[1]);
        // }
        // return sets.size();
    }
}