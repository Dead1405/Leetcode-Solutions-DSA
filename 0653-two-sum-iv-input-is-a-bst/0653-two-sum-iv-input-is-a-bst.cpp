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
    void inorder(vector<int>& arr,TreeNode* root){
        if(!root) return; 
        inorder(arr,root->left);
        arr.push_back(root->val);
        inorder(arr,root->right);
    }
    bool findTarget(TreeNode* root, int k) {
        vector<int> array;
        inorder(array,root);
        int start = 0, end = array.size()-1;
        while(start<end){
            if(array[start]+array[end] == k) return true;
            else if(array[start] + array[end] < k) start++;
            else end--;
        }
        return false;
    }
};