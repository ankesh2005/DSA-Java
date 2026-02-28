import java.util.stream.Gatherer.Integrator;
import java.util.*;

public class Traversal {
  static class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
      this.val = val;
    }
  }

  public static void preorder(Node root) {
    if (root == null)
      return;
    System.out.print(root.val + " ");
    preorder(root.left);
    preorder(root.right);
  }

  public static void postorder(Node root) {
    if (root == null)
      return;
    postorder(root.left);
    postorder(root.right);
    System.out.print(root.val + " ");
  }

  public static void inorder(Node root) {
    if (root == null)
      return;
    inorder(root.left);
    System.out.print(root.val + " ");
    inorder(root.right);
  }

  public static void predfs(Node root, ArrayList<Integer> ans) {
    if (root == null)
      return;
    ans.add(root.val);
    predfs(root.left, ans);
    predfs(root.right, ans);
  }

  public static void bfs(Node a) {
    Queue<Node> q = new ArrayDeque<>();
    q.add(a);
    while (q.size() > 0) {
      Node temp = q.poll();
      System.out.print(temp.val + " ");
      if (temp.left != null)
        q.add(temp.left);
      if (temp.right != null)
        q.add(temp.right);
    }
  }
  public static void preOrderIterative(Node root){
    if(root==null)return;
    Stack<Node> stack=new Stack<>();
    stack.push(root);
    while(!stack.isEmpty()){
      Node temp=stack.pop();
      System.out.print(temp.val+" ");
      if(temp.right!=null)stack.push(temp.right);
      if(temp.left!=null)stack.push(temp.left);
    }
  }
  public static void postOrderIterative(Node root){
    if(root==null) return ;
    Stack<Node>stack=new Stack<>();
    ArrayList<Integer> ans=new ArrayList<>();
    stack.push(root);
    while(!stack.isEmpty()){
      Node temp=stack.pop();
      ans.add(temp.val);
      if(temp.left!=null)stack.push(temp.left);
      if(temp.right!=null)stack.push(temp.right);
    }
    Collections.reverse(ans);
    System.out.println(ans);
  }
  public static void inorderIterative(Node root){
    if (root==null) return;
    ArrayList<Integer> ans=new ArrayList<>();
    Stack<Node> stack=new Stack<>();
    Node curr=root;
    while (!stack.isEmpty() || curr!=null) {
      if (curr!=null) {
        if(curr.left!=null){
          stack.push(curr);
          curr=curr.left;
        }else{
          ans.add(curr.val);
          curr=curr.right;
        }
      }
      else{
        Node top=stack.pop();
        ans.add(top.val);
        curr=top.right;
      }
    }
    System.out.println(ans);
  }

  static class Pair {
    Node node;
    int level;

    Pair(Node n, int l) {
      node = n;
      level = l;
    }
  }

  public static ArrayList<Integer> zigZagTraversal(Node root) {
    // code here
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    Queue<Pair> q = new ArrayDeque<>();
    q.add(new Pair(root, 0));
    while (q.size() > 0) {
      Pair p = q.poll();
      Node pn = p.node;
      int lvl = p.level;
      if (ans.size() == lvl) {
        ans.add(new ArrayList<>());
      }
      ans.get(lvl).add(pn.val);
      if (pn.left != null)
        q.add(new Pair(pn.left, lvl + 1));
      if (pn.right != null)
        q.add(new Pair(pn.right, lvl + 1));
    }
    ArrayList<Integer> res = new ArrayList<>();
    for (int i = 0; i < ans.size(); i++) {
      ArrayList<Integer> x = ans.get(i);
      if (i % 2 == 0) {
        res.addAll(x);
      } else {
        Collections.reverse(x);
        res.addAll(x);
      }
    }
    return res;
  }

  public static void knthLevel(Node root, int level, int k) {
    if (root == null)
      return;
    if (level == k)
      System.out.print(root.val + " ");
    knthLevel(root.left, level + 1, k);
    knthLevel(root.right, level + 1, k);
  }

  private static int levels(Node root) {
    if (root == null)
      return 0;
    return 1 + Math.max(levels(root.left), levels(root.right));
  }

  public static boolean isBalanced(Node root) {
    // code here
    if (root == null)
      return true;
    int leftLevels = levels(root.left);
    int rightLevels = levels(root.right);
    if (Math.abs(leftLevels - rightLevels) > 1)
      return false;
    return isBalanced(root.left) && isBalanced(root.right);
  }

  public static void main(String[] args) {
    Node a = new Node(5);
    Node b = new Node(3);
    Node c = new Node(7);
    Node d = new Node(2);
    Node e = new Node(4);
    Node f = new Node(6);
    Node g = new Node(9);
    Node h = new Node(10);

    // Build the tree
    a.left = b;
    a.right = c;
    b.left = d;
    b.right = e;
    c.left = f;
    f.left = g;
    g.left = h;

    // preorder(a);
    // System.out.println();
    // inorder(a);
    // System.err.println();
    // postorder(a);
    // ArrayList<Integer> ans=new ArrayList<>();
    // predfs(a, ans);
    // System.out.println();
    // // bfs
    // bfs(a);
    // System.out.println();
    // // zigzag
    // System.out.println(zigZagTraversal(a));
    // knthLevel(a, 0, 1);
    // preOrderIterative(a);
    // postOrderIterative(a);
    inorderIterative(a);
  }
}
