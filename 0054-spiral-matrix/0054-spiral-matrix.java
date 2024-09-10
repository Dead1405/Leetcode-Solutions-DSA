class Solution {
    public boolean inBound(int row, int col, int rLow, int rHigh, int cLow, int cHigh){
        return row>=rLow && row<rHigh && col>=cLow && col<cHigh; 
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<Integer>();
        int[][] drn = {{0,1},{1,0},{0,-1},{-1,0}};
        int dir = 0, row = 0, col = 0, rLow = 0, rHigh = matrix.length, cLow = 0, cHigh = matrix[0].length;
        for(int i = 0; i < matrix.length*matrix[0].length; i++){
            ans.add(matrix[row][col]);
            if(!inBound(row+drn[dir][0],col+drn[dir][1],rLow,rHigh,cLow,cHigh)){
                if(drn[dir][0] == 1) cHigh--;
                else if(drn[dir][0] == -1) cLow++;
                else if(drn[dir][1] == 1) rLow++;
                else rHigh--;
                dir = (dir+1)%4;
            }
            row += drn[dir][0];
            col += drn[dir][1];
        }
        return ans;
    }
}