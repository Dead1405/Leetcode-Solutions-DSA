/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int helper(PriorityQueue<Integer> pq, TreeNode root){
        //leaf is perfect
        if(root.left == null && root.right == null){
            pq.add(1);
            return 1;
        }
        else if (root.left == null){
            helper(pq, root.right);
            return 0;
        }
        else if(root.right == null){
            helper(pq, root.left);
            return 0;
        }
        int left = helper(pq, root.left);
        int right = helper(pq, root.right);
        if(left > 0 && left == right){
            pq.add(left + right + 1);
            return left + right + 1;
        }
        else return 0;
    }
    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {return b - a;});
        helper(pq, root);
        for(int i = 0; i < k-1; i++){
            if(pq.isEmpty()) return -1;
            pq.poll();
            
        }
        return pq.isEmpty() ? -1 : pq.poll();
    }
}