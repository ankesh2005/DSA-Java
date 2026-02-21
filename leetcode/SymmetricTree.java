import javax.swing.tree.TreeNode;
// lc-101
public class SymmetricTree {

  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Solution {
    private boolean isIdentical(TreeNode p,TreeNode q){
        if(p==null && q==null) return true;
        if(p==null || q==null ) return false;
        // bug hai yha par bina val check be bina bhi answer aa jata hai
        if(p.val!=q.val) return false;
        // return isIdentical(p.left,q.right)&&isIdentical(p.right,q.left);
         return isIdentical(p.left,q.left)&&isIdentical(p.right,q.right);
    }
    private void mirror(TreeNode root){
        if(root==null) return;
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        mirror(root.left);
        mirror(root.right);
    }
    public boolean isSymmetric(TreeNode root) {
        // return isIdentical(root.left,root.right);
        mirror(root.left);
        return isIdentical(root.left,root.right);
    }
}
}
