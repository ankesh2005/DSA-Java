import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class PathSum2 {
  // 113. Path Sum II
class Solution {
    private void helper(TreeNode root,int ts,List<List<Integer>> ans,List<Integer>temp,int cs){
        if(root==null) return ;
        cs+=root.val;
        temp.add(root.val);
        if(root.left==null && root.right==null){
            if(cs==ts){
                ans.add(new ArrayList<>(temp));
            }
            temp.remove(temp.size()-1);
            return ;
        }
        helper(root.left,ts,ans,temp,cs);
        helper(root.right,ts,ans,temp,cs);
        temp.remove(temp.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(root,targetSum,ans,new ArrayList<>(),0);
        return ans;
    }
}
}
