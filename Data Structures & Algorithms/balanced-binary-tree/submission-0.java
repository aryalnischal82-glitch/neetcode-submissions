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
    Map<TreeNode,Integer> cache;
    public boolean isBalanced(TreeNode root) {
        this.cache=new HashMap<>();
        height(root);
        return dfs(root);
    }

    private boolean dfs(TreeNode node){
        if(node==null) return true;
        int leftHeight=(node.left==null)? 0: cache.get(node.left);
        int rightHeight=(node.right==null)? 0: cache.get(node.right);
        if(Math.abs(rightHeight-leftHeight)>1) return false;
        return dfs(node.left) && dfs(node.right);
    }

    

    private int height(TreeNode node){
        if(node==null) return 0;
        if(cache.containsKey(node)) return cache.get(node);
        int nodeHeight=Math.max(height(node.left),height(node.right))+1;
        cache.put(node,nodeHeight);
        return nodeHeight;
    }
}
