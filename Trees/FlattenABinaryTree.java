import java.util.ArrayList;

import javax.swing.tree.TreeNode;

import org.w3c.dom.Node;

public class FlattenABinaryTree {
  static class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
      this.val = val;
    }
  }
  public static void predfs(Node root,ArrayList<Node> arr){
    if(root==null) return;
    arr.add(root);
    predfs(root.left, arr);
    predfs(root.right, arr);
  }
  public static Node flatten1(Node root){
    ArrayList<Node> arr=new ArrayList<>();
    predfs(root,arr);
    Node head=new Node(0);
    Node temp=head;
    for(int i=0;i<arr.size();i++){
      Node x=arr.get(i);
      x.left=null;
      x.right=null;
      temp.right=x;
      temp=x;
    }
    return head.right;
  }
  // Morris traversal used
      public static void flatten(TreeNode root) {
        TreeNode curr=root;
        while(curr!=null){
            if(curr.left!=null){
                TreeNode pred=curr.left;
                while(pred.right!=null){
                    pred=pred.right;
                }
                pred.right=curr.right;
                curr.right=curr.left;
                curr.left=null;
            }else{
                curr=curr.right;
            }
        }
    }
  public static void flatten2(Node root){
    if(root==null)return;
    Node lft=root.left;
    Node rgt=root.right;
    root.left=null;
    root.right=null;
    flatten(lft);
    flatten(rgt);
    root.right=lft;
    Node last=root;
    while (last.right!=null) {
      last=last.right;
    }
    last.right=rgt;
  }
  static void display(Node root){
    if(root==null) return;
    display(root.left);
    System.out.print(root.val+" "); 
    display(root.right);
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

      // Build the tree
      a.left = b;
      a.right = c;
      b.left = d;
      b.right = e;
      c.left = f;
      f.left=g;
      g.left=h;
    //      5
    //    /   \
    //   3     7
    //  /\    /
    // 2  4  6 
    //      /
    //     9
    //    /
    //   10
    // Node flat=flatten(a);
    display(a);
    flatten(a);
    System.out.println();
    display(a);
   }
}
