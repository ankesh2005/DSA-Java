import org.w3c.dom.Node;

public class BuildTreeFromInordernPreOrder {
class Solution {
    public static Node buildTree(int inorder[], int preorder[]) {
        int n=inorder.length;
        return build(0,n-1,0,n-1,inorder,preorder);
    }
    public static Node build(int inlo,int inhi,int prelo,int prehi,int[] inorder,int[] preorder){
        if(inlo>inhi) return null;
        int r=0;
        int val=preorder[prelo];
        Node root=new Node(val);
        for(int i=inlo;i<=prehi;i++){
            if(val==inorder[i]){
                r=i;
                break;
            }
        }
        int cnt=r-inlo;
        root.left=build(inlo,r-1,prelo+1,prehi+cnt,inorder,preorder);
        root.right=build(r+1,inhi,prelo+cnt+1,prehi,inorder,preorder);
        return root;
        
    }
}
}
