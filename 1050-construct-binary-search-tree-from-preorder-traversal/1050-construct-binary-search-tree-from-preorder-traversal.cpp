/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    TreeNode* mkTree(vector<int>& preorder,int start,int end){
        if(start>end) return NULL;
        // if(start==end){
        //     return TreeNode(preorder[start]);
        else{
            int leftStart = start+1;
            int leftEnd=start;
            while(leftEnd+1<=end && preorder[start]>preorder[leftEnd+1]){
                leftEnd++;
            }
            int rightStart = leftEnd+1;
            int rightEnd = end;
            TreeNode* root = new TreeNode(preorder[start]);
            root->left = mkTree(preorder,leftStart,leftEnd);
            root->right = mkTree(preorder,rightStart,rightEnd);
            return root;
        }
    }
    TreeNode* bstFromPreorder(vector<int>& preorder) {
       return mkTree(preorder,0,preorder.size()-1) ;
    }
};