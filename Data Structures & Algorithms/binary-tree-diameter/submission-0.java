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
    int res; 
    public int diameterOfBinaryTree(TreeNode root) {
        this.cache=new HashMap<>();
        this.res=0;
        height(root);
        dfs(root);
        return res;
    }

    private void dfs(TreeNode node){
        if(node==null) return;
        int leftHeight=(node.left==null)? 0: cache.get(node.left);
        int rightHeight=(node.right==null)? 0: cache.get(node.right);
        int diameterOfNode=leftHeight+rightHeight;
        res=Math.max(res,diameterOfNode);
        dfs(node.left);
        dfs(node.right);
    }



    private int height(TreeNode node){
        if(node==null) return 0;
        if(cache.containsKey(node)) return cache.get(node);
        int nodeHeight=Math.max(height(node.left),height(node.right))+1;
        cache.put(node,nodeHeight);
        return nodeHeight;
    }

 
}
