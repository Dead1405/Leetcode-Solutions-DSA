/**
 * Definition for singly-linked list.-
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    bool inBound (int x,int y,int lowerX,int upperX,int lowerY,int upperY){
        return x >= lowerX && x < upperX && y >= lowerY && y < upperY;
    }
    vector<vector<int>> spiralMatrix(int m, int n, ListNode* head) {
        vector<vector<int>> drn = {{0,1},{1,0},{0,-1},{-1,0}};
        vector<vector<int>> matrix(m,vector<int>(n,-1));
        int i = 0,x = 0 , y =0,upperX=m,lowerX=0,upperY = n, lowerY = 0;
        while(head){
            matrix[x][y] = head->val;
            head = head->next;
            if(!inBound(x+drn[i][0],y+drn[i][1],lowerX,upperX,lowerY,upperY)){
                drn[i][0]?(drn[i][0]==1?upperY--:lowerY++):(drn[i][1]==1?lowerX++:upperX--);
                i = (i+1)%4;
            }
            x += drn[i][0];
            y += drn[i][1];
        }
        return matrix;
    }
};
// class Solution {
// public:
//     bool inBound(int x, int y, int lowerX, int upperX, int lowerY, int upperY) {
//         return x >= lowerX && x < upperX && y >= lowerY && y < upperY;
//     }
//     vector<vector<int>> spiralMatrix(int m, int n, ListNode* head) {
//         vector<vector<int>> drn = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
//         vector<vector<int>> matrix(m, vector<int>(n, -1));
//         int dir = 0, row = 0, col = 0, rLow = 0, rHigh = m, cLow = 0, cHigh = n;
//         while (head) {
//             matrix[row][col] = head->val;
//             head = head->next;
//             if (!inBound(row,col,rLow,rHigh,cLow,cHigh)){
//                 drn[dir][0]?(drn[dir][0]==1?):();
//             }
//         }
//         return matrix;
//     }
// }