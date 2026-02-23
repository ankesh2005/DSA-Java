import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Queue;
import java.util.stream.Gatherer.Integrator;
import java.util.Collections;
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
    knthLevel(a, 0, 1);
  }
}
