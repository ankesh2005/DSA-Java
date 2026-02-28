import org.w3c.dom.Node;

public class FindMinDistanceBetween2Nodes {
   static class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
      this.val = val;
    }
  }
  private static Node lca(Node root,int p,int q){
    if(root==null) return null;
    if(root.val==p||root.val==q) return root;
    Node l=lca(root.left, p, q);
    Node r=lca(root.right, p, q);
    if(l!=null && r!=null) return root;
    return l==null?r:l;
  }
  private static int min(Node root,int a,int b){
    if(root==null) return 0;
    Node lca=lca(root, a, b);
    int[] arr={0,0};
    dfs(root,a,b,0,arr);
    return arr[0]+arr[1];
  }
  private static void dfs(Node root, int a, int b, int levels, int[] arr) {
    if(root==null) return ;
    if(root.val==a) arr[0]=levels;
    if(root.val==b) arr[1]=levels;
    dfs(root.right, a, b, levels+1, arr);
    dfs(root.left, a, b, levels+1, arr);
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
    f.left = g;
    g.left = h;

    System.out.print(min(a,3,10));
  }
}
