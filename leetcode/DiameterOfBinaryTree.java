public class DiameterOfBinaryTree {
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
    private int levels(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(levels(root.left),levels(root.right));
    }
    private int levels2(TreeNode root,int[] dia){
        if(root==null) return 0;
        int left=levels2(root.left,dia);
        int right=levels2(root.right,dia);
        dia[0]=Math.max(dia[0],left+right);
        return 1+Math.max(left,right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        // if(root==null) return 0;
        // int left=diameterOfBinaryTree(root.left);
        // int right=diameterOfBinaryTree(root.right);
        // int dia=levels(root.left)+levels(root.right);
        // return Math.max(left,Math.max(right,dia));
        int[] dia=new int[1];
        levels2(root,dia);
        return dia[0];
    }
}
}
