import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class BinaryTreeLevelOrderTraversal {
  // lc-102
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
    private class Pair{
        TreeNode node;
        int level;
        Pair(TreeNode n,int l){
            node=n;
            level=l;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<Pair> q=new ArrayDeque<>();
        q.add(new Pair(root,0));
        while(q.size()>0){
            Pair p=q.poll();
            TreeNode pn=p.node;
            int lvl=p.level;
            if(ans.size()==lvl){
                ans.add(new ArrayList<>());
            }
            ans.get(lvl).add(pn.val);
            if(pn.left!=null) q.add(new Pair(pn.left,lvl+1));
            if(pn.right!=null) q.add(new Pair(pn.right,lvl+1));
        }
        return ans;
    }
}
}
