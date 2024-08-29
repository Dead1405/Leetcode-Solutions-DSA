/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left),
 * right(right) {}
 * };
 */
class Solution {
public:
    bool isValidBST(TreeNode* root) {
        bool first = false;
        int prev;
        stack<TreeNode*> stck;
        while (root || !stck.empty()) {
            while (root) {
                stck.push(root);
                root = root->left;
            }
            root = stck.top();
            if (first && root->val <= prev)
                return false;
            first = true;
            prev = root->val;
            stck.pop();
            root = root->right;
        }
        return true;
    }
};