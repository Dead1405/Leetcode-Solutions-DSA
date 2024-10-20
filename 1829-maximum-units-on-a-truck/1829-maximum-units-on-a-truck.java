class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int i = 0, ans = 0;
        while(i < boxTypes.length && truckSize - boxTypes[i][0]> 0){
            truckSize -= boxTypes[i][0];
            ans += boxTypes[i][0] * boxTypes[i][1];
            i++;
        }
        if(i < boxTypes.length) ans += boxTypes[i][1] * truckSize;
        return ans;
    }
}