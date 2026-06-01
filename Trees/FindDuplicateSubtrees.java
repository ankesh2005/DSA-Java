import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.tree.TreeNode;

public class FindDuplicateSubtrees {
  // lc-652. Find Duplicate Subtrees
  class Solution {
    public String dfs(TreeNode root,Map<String,Integer>map,List<TreeNode>res){
        if(root==null)return "N";
        String s=Integer.toString(root.val)+","+dfs(root.left,map,res)+","+dfs(root.right,map,res);
        if(map.containsKey(s) && map.get(s)==1)res.add(root);
        map.put(s,map.getOrDefault(s,0)+1);
        return s;
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res=new ArrayList<>();
        Map<String,Integer>map=new HashMap<>();
        dfs(root,map,res);
        return res;

    }
}
}
