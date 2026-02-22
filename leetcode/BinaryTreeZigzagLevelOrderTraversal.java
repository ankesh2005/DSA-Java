import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {
  //lc-103
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q=new ArrayDeque<>();
        q.add(root);
        int turn=0;
        while(q.size()>0){
            ArrayList<Integer> temp=new ArrayList<>();
            int fixedSize=q.size();
            for(int i=0;i<fixedSize;i++){
                TreeNode node=q.poll();
                temp.add(node.val);
                if(node.left!=null)q.add(node.left);
                if(node.right!=null)q.add(node.right);
            }
            if(turn==0){
                ans.add(temp);
                turn=1;
            }else{
                Collections.reverse(temp);
                ans.add(temp);
                turn=0;
            }
        }
        return ans;
    }
}
}
