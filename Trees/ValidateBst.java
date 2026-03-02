import java.util.ArrayList;

import org.w3c.dom.Node;

public class ValidateBst {
  
class Pair{
    int min;
    int max;
    Pair(int min,int max){
        this.min=min;
        this.max=max;
    }
}
class Triplet{
    int min;
    int max;
    boolean isBst;
    Triplet(int min,int max,boolean isBst){
        this.min=min;
        this.max=max;
        this.isBst=isBst;
    }
}

class Solution {
    static boolean flag;
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
    // public Pair maxmin(Node root){
    //     if(root==null)return new Pair(Integer.MAX_VALUE,Integer.MIN_VALUE);
    //     Pair lft=maxmin(root.left);
    //     Pair rgt=maxmin(root.right);
    //     int max=Math.max(root.data,Math.max(lft.max,rgt.max));
    //     int min=Math.min(root.data,Math.min(lft.min,rgt.min));
    //     if(lft.max>root.data || root.data>rgt.min) flag=false;
    //     return new Pair(min,max);
    // }
    public Triplet maxmin(Node root){
        if(root==null)return new Triplet(Integer.MAX_VALUE,Integer.MIN_VALUE,true);
        Triplet lft=maxmin(root.left);
        Triplet rgt=maxmin(root.right);
        int max=Math.max(root.data,Math.max(lft.max,rgt.max));
        int min=Math.min(root.data,Math.min(lft.min,rgt.min));
        boolean isBst=lft.isBst && rgt.isBst &&(lft.max<root.data && root.data<rgt.min);
        return new Triplet(min,max,isBst);
    }
    public boolean isBST(Node root) {
        // code here
        ArrayList<Integer> arr=new ArrayList<>();
        int[] prev=new int[]{-1};
        // return inorder(root,prev);
        // for (int i = 1; i < arr.size(); i++) {
        //     if (arr.get(i) < arr.get(i - 1)) { 
        //     return false; }
        //     }
        // return true;
        
        // flag=true;
        return maxmin(root).isBst;
        // return flag;
    }
}
}
