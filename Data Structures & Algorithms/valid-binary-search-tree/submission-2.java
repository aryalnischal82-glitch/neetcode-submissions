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
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        return isValidBST(root.left,Integer.MIN_VALUE,root.val)
         && isValidBST(root.right,root.val,Integer.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, int permissibleMin, int permissibleMax){
        if(node==null) return true;
        //[-inifinity,2]. [2,infinity]
        boolean isValid=(node.val>permissibleMin && node.val<permissibleMax);
        if(!isValid){
            return false;
        } 
        return isValidBST(node.left,permissibleMin,Math.min(permissibleMax,node.val)) &&
        isValidBST(node.right,Math.max(permissibleMin,node.val),permissibleMax);
    }


}
