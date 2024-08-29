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
    void inorder(TreeNode* root,vector<int>& ans){
    if(!root) return;
    else{
        inorder(root->left,ans);
        ans.push_back(root->val);
        inorder(root->right,ans);
    }
}
int partition(vector<int>& ans,int low,int high){
    int i = low-1;
    for(int j =low;j<=high-1;j++){
        if(ans[j]<=ans[high]){
            i++;
            swap(ans[j],ans[i]);
        }
    }
    i++;
    swap(ans[high],ans[i]);
    return i;
}
int quickSelect(vector<int>& ans,int low,int high,int k){
    
        int pi = partition(ans,low,high);
        if(pi==k-1){
            return ans[pi];
        }else if(pi<k-1){
            return quickSelect(ans,pi+1,high,k);
        }
        else{
            return quickSelect(ans,low,pi-1,k);
        }
    
}
int kthSmallest(struct TreeNode* root, int k) {
    vector<int> ans;
    inorder(root,ans);
    return quickSelect(ans,0,ans.size()-1,k);
}

};