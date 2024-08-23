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
    int helper(TreeNode* root,int ans){
        if(!root->left && !root->right) return ans;
        if(!root->right) return 2*ans;
        return max(helper(root->left,2*ans),helper(root->right,ans*2+1));
    }
    int countNodes(TreeNode* root) {
        if(!root){
            return 0;
        }
        return helper(root,1);
    }
};