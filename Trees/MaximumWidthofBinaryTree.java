import java.util.ArrayDeque;
import java.util.Deque;

import javax.swing.tree.TreeNode;

public class MaximumWidthofBinaryTree {
  // lc-662. Maximum Width of Binary Tree
  class Solution {
    class Pair{
        TreeNode root;
        int idx;
        Pair(TreeNode root,int idx){
            this.root=root;
            this.idx=idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Deque<Pair>q=new ArrayDeque<>();
        q.add(new Pair(root,0));
        int max=0;
        while(!q.isEmpty()){
            int n=q.size();
            int first=q.peekFirst().idx;
            int last=q.peekLast().idx;
            max=Math.max(max,last-first);
            while(n>0){
                Pair p=q.poll();
                int idx=p.idx;
                TreeNode node=p.root;
                if(node.left!=null)q.add(new Pair(node.left,2*idx));
                if(node.right!=null)q.add(new Pair(node.right,2*idx+1));
                n--;
            }
        }
        return max+1;
    }
}
}
