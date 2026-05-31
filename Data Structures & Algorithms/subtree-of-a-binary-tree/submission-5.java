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
    StringBuilder rootStr;
    StringBuilder subRootStr;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        this.rootStr=new StringBuilder();
        this.subRootStr=new StringBuilder();
        dfs(root,rootStr);
        dfs(subRoot,subRootStr);
        return rootStr.toString().contains(subRootStr.toString());
    }



    private void dfs(TreeNode node, StringBuilder str){
        if(node==null){
            str.append("#");
            return;
        }
        str.append("*");
        str.append(node.val);
        str.append(",");
        dfs(node.left,str);
        dfs(node.right,str);
    }

    
}
