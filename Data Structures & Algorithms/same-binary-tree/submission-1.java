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
    StringBuilder pStr;
    StringBuilder qStr;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        this.pStr=new StringBuilder();
        this.qStr=new StringBuilder();
        dfs(p,pStr);
        dfs(q,qStr);
        return pStr.toString().equals(qStr.toString());
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
