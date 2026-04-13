import java.util.Map;

import javax.swing.tree.TreeNode;

public class HouseRobberIII {

  
class Solution {
  //lc-337. House Robber III
    Map<TreeNode,Integer>dp;
    int dfs(TreeNode root){
        if(root==null)return 0;
        if(dp.containsKey(root))return dp.get(root);
        int rob=root.val;
        if(root.left!=null ){
            rob+=dfs(root.left.left)+dfs(root.left.right);
        }
        if(root.right!=null){
            rob+=dfs(root.right.left)+dfs(root.right.right);
        }
        int notrob=dfs(root.left)+dfs(root.right);
        dp.put(root,Math.max(rob,notrob));
        return dp.get(root);
        

    }
    //return array for take and not take for node
    public int[] dfs2(TreeNode root){
        if(root==null)return new int[]{0,0};
        
        int[] left=dfs2(root.left);
        int[] right=dfs2(root.right);
        int maxval[]=new int[2];
        int rob=root.val+left[1]+right[1];
        int notrob=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        maxval[0]=rob;
        maxval[1]=notrob;
        return maxval;

    }
    public int rob(TreeNode root) {
        // dp=new HashMap<>();
        // return dfs(root);
        int res[]=dfs2(root);
        return Math.max(res[0],res[1]);
    }
}
}