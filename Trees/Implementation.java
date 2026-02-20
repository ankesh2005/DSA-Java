public class Implementation {
    static class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
      this.val = val;
    }
  }
  static void display(Node root){
    if(root==null) return;
    System.out.print(root.val+" ");
    display(root.left);
    display(root.right);
  }
  static int getSize(Node node) {
        // code here
        if(node==null) return 0;
        return 1+getSize(node.left)+getSize(node.right);
    }
    static int getSum(Node root) {
        // Your code here
        if(root==null) return 0;
        return root.val+getSum(root.left)+getSum(root.right);
    }
    static int getProduct(Node root){
      if(root==null) return 1;
      return root.val*getProduct(root.left)*getProduct(root.right);
    }
    public static int findMax(Node root) {
        if(root==null) return Integer.MIN_VALUE;
        return Math.max(root.val,Math.max(findMax(root.left),findMax(root.right)));
    }

    public static int findMin(Node root) {
        if(root==null) return Integer.MAX_VALUE;
        return Math.min(root.val,Math.min(findMin(root.left),findMin(root.right)));
    }
    public static int findLevels(Node root){
      if(root==null) return 0;
      return 1+Math.max(findLevels(root.left), findLevels(root.right));
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
      System.out.print("display: ");
      display(a);
      System.out.println();
      System.out.println("size of tree: "+getSize(a));
      System.out.println("sum of tree: "+getSum(a));
      System.out.println("product of tree: "+getProduct(a));
      System.out.println("Minimum ele: "+findMin(a));
      System.out.println("Maximum ele: "+findMax(a));
      System.out.println("levels: "+findLevels(a));

    }
}
