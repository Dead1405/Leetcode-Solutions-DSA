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
    TreeNode* bstFromPreorder(vector<int>& preorder) {
        TreeNode* root =new TreeNode(preorder[0]);
        for(int i  =1; i<preorder.size();i++){
            TreeNode* temp = root;
            while(temp->val > preorder[i] && temp->left || temp->right){
                if(temp->val > preorder[i]) temp = temp->left;
                else temp = temp->right;
            }
            if(temp->val > preorder[i]){
                temp->left = new TreeNode(preorder[i]);
            }
            else{
                temp->right = new TreeNode(preorder[i]);
            }
        }
        return root;
    }
};