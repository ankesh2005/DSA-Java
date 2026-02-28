import java.util.ArrayList;

import org.w3c.dom.Node;

public class TreeBoundaryTraversal {
 

class Solution {
    ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(root.data);
        if(root.left==null && root.right==null) return ans;
        leftBoundary(root.left,ans);
        leafNodes(root,ans);
        rightBoundary(root.right,ans);
        return ans;
    }
    private static void leftBoundary(Node root,ArrayList<Integer>ans){
      if(root==null)return;
      if(root.left==null && root.right==null)return;
      ans.add(root.data);
      if(root.left!=null){
        leftBoundary(root.left, ans);
      }else{
        leftBoundary(root.right, ans);
      }
    }
    private static void leafNodes(Node root,ArrayList<Integer>ans){
      if(root==null)return;
      if(root.left==null && root.right==null)ans.add(root.data);
      leafNodes(root.left, ans);
      leafNodes(root.right, ans);
    }
    private static void rightBoundary(Node root,ArrayList<Integer> ans){
      if(root==null)return ;
      if (root.left==null && root.right==null) return;
      if(root.right!=null)rightBoundary(root.right, ans);
      else rightBoundary(root.left, ans);
      ans.add(root.data);
    }
} 
}
