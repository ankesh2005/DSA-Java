import javax.swing.tree.TreeNode;

public class MaximumSumBSTinBinaryTree {
  // lc-1373 Maximum Sum BST in Binary Tree
  class Quad{
    int max;
    int min;
    int sum;
    boolean isBst;
    Quad(int max,int min,int sum,boolean isBst){
        this.max=max;
        this.min=min;
        this.sum=sum;
        this.isBst=isBst;
    }
}

class Solution {
    static int maxSum;
     public Quad bst(TreeNode root){
        if(root==null)return new Quad(Integer.MIN_VALUE,Integer.MAX_VALUE,0,true);
        Quad lft=bst(root.left);
        Quad rgt=bst(root.right);
        int  max=Math.max(root.val,Math.max(lft.max,rgt.max));
        int min=Math.min(root.val,Math.min(lft.min,rgt.min));
        int sum=root.val+lft.sum+rgt.sum;
        boolean isBst=lft.isBst && rgt.isBst && (lft.max<root.val && root.val<rgt.min);
        if(isBst)maxSum=Math.max(maxSum,sum);
        return new Quad(max,min,sum,isBst);
    }
    public int maxSumBST(TreeNode root) {
        maxSum=0;
        bst(root);
        return maxSum;
    }
}
}
