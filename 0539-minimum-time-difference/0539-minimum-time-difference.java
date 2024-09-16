class Solution {
    public int timeToMin(String s){return Integer.parseInt(s.substring(0,2))*60 + Integer.parseInt(s.substring(3,5));}
    public int timeCmp(int t1, int t2){
        return Math.min(t2-t1, 1440 + t1- t2);
    }
    public int findMinDifference(List<String> timePoints) {
        if(timePoints.size() > 1440) return 0;//pigeon hole
        Collections.sort(timePoints);
        int ans = timeCmp(timeToMin(timePoints.get(0)),timeToMin(timePoints.get(timePoints.size()-1)));
        for(int i = 0; i < timePoints.size() - 1; i++){
            int diff = timeCmp(timeToMin(timePoints.get(i)),timeToMin(timePoints.get(i+1)));
            if (diff < ans) ans = diff;
        }
        return ans;
    }
}