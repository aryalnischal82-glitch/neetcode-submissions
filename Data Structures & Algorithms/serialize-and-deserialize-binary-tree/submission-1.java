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

public class Codec {
    int idx;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder strB=new StringBuilder();
        dfs(root,strB);
        return strB.toString();
    }


    private void dfs(TreeNode node, StringBuilder str){
        if(node==null){
            str.append("#").append(",");
            return;
        }
        str.append(node.val).append(",");
        dfs(node.left,str);
        dfs(node.right,str);
    }
    // 1,2,#,#,3,4,#,#,5,#,#,
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
      String[] vals=data.split(",");
      this.idx=0;
      //vals->[1,2,#,#,3,4,#,#,5,#,#]
      return deserialize(vals);
    }

    public TreeNode deserialize(String[] vals){
        if(idx>=vals.length || vals[idx].equals("#")) return null;

        TreeNode root=new TreeNode(Integer.parseInt(vals[idx]));
        idx++;
        root.left=deserialize(vals);
        idx++;
        root.right=deserialize(vals);
        return root;
    }
}
