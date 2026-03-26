package DepthSearchFirst;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
  // lc-199. Binary Tree Right Side View
    public void solve(TreeNode root,List<Integer>ans,int levels){
        if(root==null)return;
        if(ans.size()==levels)ans.add(root.val);
        else{
            ans.set(levels,root.val);
        }
        solve(root.left,ans,levels+1);
        solve(root.right,ans,levels+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>ans=new ArrayList<>();
        solve(root,ans,0);
        return ans;
    }
}
