class BSTIterator {
public:
    stack<TreeNode*> stck;
    TreeNode* root=NULL;
    BSTIterator(TreeNode* root) {
        while (root)
        {
            stck.push(root);
            root = root->left;
        }
    }
    
    int next() {
        while (root)
        {
            stck.push(root);
            root = root->left;
        }
        TreeNode* temp = stck.top();
        root = temp->right;
        stck.pop();
        return temp->val;     
    }
    
    bool hasNext() {
        return root || !stck.empty();
    }
};