import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Node;

public class LowestCommonAncestorOfaBinaryTree {
  //lc-236
class Solution {
    private boolean exist(Node root,int n){
        if(root==null) return false;
        if(root.data==n) return true;
        return exist(root.left,n)|| exist(root.right,n);
    }
    Node lca1(Node root, int n1, int n2) {
        // code here
        if(root==null) return null;
        if(root.data==n1 || root.data==n2) return root;
        boolean left=exist(root.left,n1);
        boolean right=exist(root.right,n2);
        if(left && right) return root;
        if(!left && !right) return root;
        if(left && !right)return lca1(root.left,n1,n2);
        else{
            return lca1(root.right,n1,n2);
        }
    }
    private boolean findPath(Node root,List<Node> list,int n){
        if(root==null)return false;
        list.add(root);
        if(root.data==n)return true;
        if(findPath(root.left,list,n)||findPath(root.right,list,n)){
            return true;
        }
        list.remove(list.size()-1);
        return false;
    }
    Node lca2(Node root, int n1, int n2) {
        List<Node> list1=new ArrayList<>();
        List<Node> list2=new ArrayList<>();
        findPath(root,list1,n1);
        if (!findPath(root, list1, n1) || !findPath(root, list2, n2)) {
        return null; // one of the nodes not found
    }
        for(int i=0;i<list1.size() && i<list2.size();i++){
            if(list1.get(i)!=list2.get(i))return list1.get(i-1);
        }
        return null;
    }
    Node lca(Node root, int n1, int n2) {
        if(root==null)return null;
        if(root.data==n1 ||root.data==n2)return root;
        Node l=lca(root.left,n1,n2);
        Node r=lca(root.right,n2,n1);
        if(l!=null && r!=null)return root;
        return (l==null)?r:l;
    }
    
}
}
