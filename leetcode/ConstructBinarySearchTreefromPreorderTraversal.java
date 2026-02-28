import org.w3c.dom.Node;

public class ConstructBinarySearchTreefromPreorderTraversal {
  class Solution {
    //lc-1008 Construct Binary Search Tree from Preorder Traversal
    private Node build(int[] pre,int prelo,int prehi){
        if(prelo>prehi) return null;
        int val=pre[prelo];
        Node root=new Node(val);
        int r=prelo+1;
        for(int i=prelo+1;i<=prehi;i++){
            if(pre[i]>val){
                r=i;
                break;
            }
        }
        root.left=build(pre,prelo+1,r-1);
        root.right=build(pre,r,prehi);
        return root;
    }
    public Node Bst(int pre[], int size) {
        return build(pre,0,size-1);
    }
}
}
