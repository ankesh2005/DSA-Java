import org.w3c.dom.Node;

public class LargestBst {
  class Quad{
    int max;
    int min;
    int size;
    boolean isBst;
    Quad(int max,int min,int size,boolean isBst){
        this.max=max;
        this.min=min;
        this.size=size;
        this.isBst=isBst;
    }
}

class Solution {
    static int maxSize;
    public static Quad bst(Node root){
        if(root==null)return new Quad(Integer.MIN_VALUE,Integer.MAX_VALUE,0,true);
        Quad lft=bst(root.left);
        Quad rgt=bst(root.right);
        int  max=Math.max(root.data,Math.max(lft.max,rgt.max));
        int min=Math.min(root.data,Math.min(lft.min,rgt.min));
        int size=1+lft.size+rgt.size;
        boolean isBst=lft.isBst && rgt.isBst && (lft.max<root.data && root.data<rgt.min);
        if(isBst)maxSize=Math.max(maxSize,size);
        return new Quad(max,min,size,isBst);
    }
    static int largestBst(Node root) {
        maxSize=0;
        bst(root);
        return maxSize;
        
    }
}
}
