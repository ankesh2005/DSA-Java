import javax.swing.tree.TreeNode;

public class AddOneRowtoTree {
  // lc-623. Add One Row to Tree
  class Solution {
    public void solve(TreeNode root,int val,int cd,int depth){
        if(root==null)return ;
        if(cd+1==depth){
            TreeNode leftNode=new TreeNode(val);
            TreeNode rightNode=new TreeNode(val);
            TreeNode templeft=root.left;
            TreeNode tempright=root.right;
            root.left=leftNode;
            leftNode.left=templeft;
            root.right=rightNode;
            rightNode.right=tempright;
            return;
        }else{
            solve(root.left,val,cd+1,depth);
            solve(root.right,val,cd+1,depth);
        }
    }
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode node=new TreeNode(val);
            node.left=root;
            return node;
        }
        solve(root,val,1,depth);
        return root;
    }
}
}
