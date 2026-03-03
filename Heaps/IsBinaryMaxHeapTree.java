package Heaps;

import org.w3c.dom.Node;

public class IsBinaryMaxHeapTree {
    int size=0;
    public boolean isHeap(Node root) {
        size=size(root);
        return isCBT(root,1)&&isMaxHeap(root);
    }
    public int size(Node root){
        if(root==null)return 0;
        return 1+size(root.left)+size(root.right);
    }
    public boolean isCBT(Node root,int idx){
        if(root==null)return true;
        if(idx>size)return false;
        return isCBT(root.left,2*idx) && isCBT(root.right,2*idx+1);
    }
    public boolean isMaxHeap(Node root){
        if(root==null)return true;
        int leftval=root.left!=null?root.left.data:Integer.MIN_VALUE;
        int rgtval=root.right!=null?root.right.data:Integer.MIN_VALUE;
        if(root.data<=leftval || root.data<=rgtval)return false;
        return isMaxHeap(root.left)&&isMaxHeap(root.right);
    }   
}

