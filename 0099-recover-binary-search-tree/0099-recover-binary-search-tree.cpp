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
    void inorder(TreeNode* root,vector<TreeNode*>& ans){
    if(!root) return;
    inorder(root->left,ans);
    ans.push_back(root);
    inorder(root->right,ans);
}

void recoverTree(struct TreeNode* root){
    vector<TreeNode*> tree;
    inorder(root,tree);
    int mistakes[2]={0};
    int k = 0;
    for(int i =0;i<tree.size()-1;i++){
        if(tree[i]->val>tree[i+1]->val){
            mistakes[k] = i+k;
            k++;
        } 
    }
    if(k==1) mistakes[1] = mistakes[0]+1;
    swap(tree[mistakes[0]]->val,tree[mistakes[1]]->val);
}
};