/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        bool isLeft =root->left && root->val > p->val || root->val > q->val;
        bool isRight =root->right && root->val < p->val || root->val < q->val;
        if(isLeft && isRight) return root;
        if((root == p || root == q) && (isLeft || isRight)) return root;
        else if(isLeft) return lowestCommonAncestor(root->left,p,q);
        else return lowestCommonAncestor(root->right,p,q);
    }
};