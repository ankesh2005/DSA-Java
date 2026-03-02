import java.util.ArrayList;

public class BinarySearchTree {
  static class Node {
    int data;
    Node left, right;

    Node(int val) {
      data = val;
      left = right = null;
    }
  }

  public boolean search(Node root, int key) {
    if (root == null)
      return false;
    if (root.data == key)
      return true;

    if (root.data > key)
      return search(root.left, key);
    else
      return search(root.right, key);
  }

  int getCount(Node root, int l, int h) {
    if (root == null)
      return 0;
    if (root.data < l)
      return getCount(root.right, l, h);
    if (root.data > h)
      return getCount(root.left, l, h);
    return 1 + getCount(root.left, l, h) + getCount(root.right, l, h);
  }

  public int nodeSum(Node root, int l, int h) {
    if (root == null)
      return 0;
    if (root.data < l)
      return nodeSum(root.right, l, h);
    if (root.data > h)
      return nodeSum(root.left, l, h);
    return root.data + nodeSum(root.left, l, h) + nodeSum(root.right, l, h);
  }

  public Node insert(Node root, int key) {
    if (root == null)
      return new Node(key);
    if (root.data > key) {
      if (root.left == null) {
        root.left = new Node(key);
      } else
        insert(root.left, key);
    }
    if (root.data < key) {
      if (root.right == null)
        root.right = new Node(key);
      else
        insert(root.right, key);
    }
    return root;
  }
  
    public void inorder(Node root,ArrayList<Integer>arr){
        if(root==null)return ;
        inorder(root.left,arr);
        arr.add(root.data);
        inorder(root.right,arr);
    }
    public boolean inorder(Node root,int[] prev){
        if(root==null)return true ;
        if(!inorder(root.left,prev))return false;
        if(prev[0]<root.data){
            prev[0]=root.data;
        }
        else{
            return false;
        }
        return inorder(root.right,prev);
    }
    public boolean isBST(Node root) {
        // code here
        ArrayList<Integer> arr=new ArrayList<>();
        int[] prev=new int[]{-1};
        //return inorder(root,prev);
        // inorder(root, arr);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) < arr.get(i - 1)) { 
            return false; }
            }
        return true;
    }
    // bst to gst
    private static int sum=0;
    private static void reverseInorder(Node root){
        if(root==null) return ;
        reverseInorder(root.right);
        sum+=root.data;
        reverseInorder(root.left);
    }
    private static void inorder(Node root){
        if(root==null) return ;
        inorder(root.left);
        sum-=root.data;
        root.data=sum;
        inorder(root.right);
    }
    public static void transformTree(Node root) {
        sum=0;
        reverseInorder(root);
        inorder(root);
    }
    public Node LCA(Node root, Node n1, Node n2) {
        if(root.data>n1.data && root.data>n2.data){
            return LCA(root.left,n1,n2);
        }
        else if(root.data<n1.data && root.data<n2.data){
           return LCA(root.right,n1,n2);
        }else return root;
    }
    private Node build(int[] arr,int lo,int hi){
        if(lo>hi)return null;
        int mid=(lo+hi)/2;
        Node root=new Node(arr[mid]);
        root.left=build(arr,lo,mid-1);
        root.right=build(arr,mid+1,hi);
        return root;
    }
    public Node sortedArrayToBST(int[] arr) {
        return build(arr,0,arr.length-1);
        
    }
}
