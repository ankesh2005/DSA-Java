import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.tree.TreeNode;

public class DeleteNodesAndReturnForest {
  // lc-1110. Delete Nodes And Return Forest
class Solution {
    TreeNode solve(TreeNode root,Set<Integer>set,List<TreeNode>res){
        if(root==null)return null;
        root.left=solve(root.left,set,res);
        root.right=solve(root.right,set,res);
        if(set.contains(root.val)){
            if(root.left!=null)res.add(root.left);
            if(root.right!=null)res.add(root.right);
            return null;
        }
        return root;
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer>toDelete=new HashSet<>();
        for(int i=0;i<to_delete.length;i++){
            toDelete.add(to_delete[i]);
        }
        List<TreeNode>res=new ArrayList<>();
        solve(root,toDelete,res);
        if(!toDelete.contains(root.val)){
            res.add(root);
        }
        return res;
    }
}
}
