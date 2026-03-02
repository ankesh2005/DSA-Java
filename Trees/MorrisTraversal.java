import java.util.ArrayList;

import org.w3c.dom.Node;

public class MorrisTraversal {
  
class Solution {
    public ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> ans=new ArrayList<>();
        Node curr=root;
        while(curr!=null){
            if(curr.left!=null){
                Node pre=curr.left;
                while(pre.right!=null && pre.right!=curr){
                    pre=pre.right;
                }
                if(pre.right==null){
                    pre.right=curr;
                    curr=curr.left;
                }else{
                    pre.right=null;
                    ans.add(curr.data);
                    curr=curr.right;
                }
            }else{
                ans.add(curr.data);
                curr=curr.right;
            }
        }
        return ans;
        
    }
}
}
