class Solution {
public:
    TreeNode* buildBST(vector<int>& preorder, int& index, int bound) {
        if (index == preorder.size() || preorder[index] > bound) {
            return NULL;
        }
        
        int val = preorder[index++];
        TreeNode* root = new TreeNode(val);
        root->left = buildBST(preorder, index, val);
        root->right = buildBST(preorder, index, bound);
        
        return root;
    }
    
    TreeNode* bstFromPreorder(vector<int>& preorder) {
        int index = 0;
        return buildBST(preorder, index, INT_MAX);
    }
};
