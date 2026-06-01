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
    int res;
    public int maxPathSum(TreeNode root) {
        this.res=Integer.MIN_VALUE;
        dfs(root);
        return this.res;
        //at every node need to run: node.val+leftPathSum+rightPathSum
        //res=Math.max(res,node.val+leftPathSum+rightPathSum)
    }

    private int dfs(TreeNode node){
        if(node==null) return 0;
        int left=Math.max(0,dfs(node.left));
        int right=Math.max(0,dfs(node.right));
        res=Math.max(res,node.val+left+right);
        return Math.max(node.val+left,node.val+right);
    }
}
