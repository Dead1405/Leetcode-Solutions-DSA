/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
 /**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
 int size =0;
void preorder(int* a,struct TreeNode* root){
    if (root==NULL)
    return;
    else{
        preorder(a,root->left);
        preorder(a,root->right);
        a[size++]=root->val;
        
    }
} 

int* postorderTraversal(struct TreeNode* root, int* returnSize) {
    size = 0;
    int * ans = (int*)malloc(sizeof(int)*100);
    preorder(ans,root);
    *returnSize = size;
    return ans;
}