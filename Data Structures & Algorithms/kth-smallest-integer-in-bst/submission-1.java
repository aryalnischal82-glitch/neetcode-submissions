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
    //inorder traversal-> left, root, right
    int k;
    int res;
    public int kthSmallest(TreeNode root, int k) {
        this.k=k;
        this.res=res;
        dfs(root);
        return this.res;
    }

    private void dfs(TreeNode node){
        if(node==null || k==0){
            return;
        }
        dfs(node.left);
        k--;
        if(k==0){
            this.res=node.val;
            return;
        }
        dfs(node.right);
    }
}
