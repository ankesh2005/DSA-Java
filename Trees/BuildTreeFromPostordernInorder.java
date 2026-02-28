import org.w3c.dom.Node;

public class BuildTreeFromPostordernInorder {
 
class Solution {
    private Node build(int inlo,int inhi,int polo,int pohi,int[] inorder,int[]postorder){
        if(inlo>inhi ||polo>pohi) return null;
        int val=postorder[pohi];
        Node root=new Node(val);
        int r=0;
        for(int i=inlo;i<=inhi;i++){
            if(inorder[i]==val){
                r=i;
                break;
            }
        }
        int cnt=r-inlo;
        root.left=build(inlo,r-1,polo,polo+cnt-1,inorder,postorder);
        root.right=build(r+1,inhi,polo+cnt,pohi-1,inorder,postorder);
        return root;
    }
    Node buildTree(int[] inorder, int[] postorder) {
        // code here
        int n=inorder.length;
        return build(0,n-1,0,n-1,inorder,postorder);
    }
} 
}
