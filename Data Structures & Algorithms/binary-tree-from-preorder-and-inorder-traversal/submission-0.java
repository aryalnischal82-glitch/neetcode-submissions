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
    int[] preorder;
    int[] inorder;
    int l;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //preorder traversal gives root 
        //look for the root in inorder traversal: vals to left of root lies on left on the tree, vals to right 
        //of root lies on right on the tree 
        this.l=preorder.length;
        this.preorder=preorder;
        this.inorder=inorder;
        return constructTree(0,l-1,0,l-1);
    }

    private TreeNode constructTree(int pLeft, int pRight, int inLeft, int inRight){
        if(pLeft>pRight || inLeft>inRight) return null;
        TreeNode root=new TreeNode(preorder[pLeft]);
        int inOrderIdx=-1;
        for(int i=inLeft;i<=inRight;i++){
            if(inorder[i]==preorder[pLeft]){
                inOrderIdx=i;
                break;
            }
        }
        int leftSize=inOrderIdx-inLeft;
        root.left=constructTree(pLeft+1,pLeft+leftSize,inLeft,inOrderIdx-1);
        root.right=constructTree(pLeft+leftSize+1,pRight,inOrderIdx+1,inRight);
        return root;

    }
    
}
