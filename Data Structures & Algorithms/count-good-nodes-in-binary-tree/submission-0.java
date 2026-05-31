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
    public int goodNodes(TreeNode root) {
        this.res=0;
        dfs(root,Integer.MIN_VALUE);
        return res;
    }

    private void dfs(TreeNode node, int maxInPath){
        if(node==null) return;
        if(node.val>=maxInPath) res++;
        dfs(node.left,Math.max(node.val,maxInPath));
        dfs(node.right,Math.max(node.val,maxInPath));
    }

    
}
