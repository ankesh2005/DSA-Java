import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Node;

public class Views {
      static class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
      this.val = val;
    }
  }
  public static void  rightViews(List<Integer> ans,int levels,Node root){
    if(root==null)return ;
    if(ans.size()<=levels) ans.add(root.val);
    else{
      ans.set(levels, root.val);
    }
    rightViews(ans, levels+1, root.left);
    rightViews(ans, levels+1, root.right);
  }
  public static void leftViews(List<Integer> ans,int levels,Node root){
    if (root==null) return;
    if(ans.size()<=levels) ans.add(root.val);
    else{
      ans.set(levels, root.val);
    }
    leftViews(ans, levels+1, root.right);
    leftViews(ans, levels+1, root.left);
  }
 public static void main(String[] args) {
      Node a = new Node(5);
      Node b = new Node(3);
      Node c = new Node(7);
      Node d = new Node(2);
      Node e = new Node(4);
      Node f = new Node(6);
      Node g=new Node(9);
      Node h=new Node(10);
    //      5
    //    /   \
    //   3     7
    //  /\    /
    // 2  4  6 
    //      /
    //     9
    //    /
    //   10

      // Build the tree
      a.left = b;
      a.right = c;
      b.left = d;
      b.right = e;
      c.left = f;
      f.left=g;
      g.left=h;
    
      List<Integer> ans=new ArrayList<>();
      rightViews(ans,0,a);
      System.out.println(ans);
      leftViews(ans, 0, a);
      System.out.println(ans);
  }
}
