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
    void inorder(TreeNode* root,vector<int>& ans,int k){
    if(!root || ans.size() == k) return;
    else{
        inorder(root->left,ans,k);
        ans.push_back(root->val);
        inorder(root->right,ans,k);
    }
}

int kthSmallest(struct TreeNode* root, int k) {
    vector<int> ans;
    inorder(root,ans,k);
    return ans[k-1];
}

};