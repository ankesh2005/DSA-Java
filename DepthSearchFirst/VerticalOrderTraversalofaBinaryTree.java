package DepthSearchFirst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VerticalOrderTraversalofaBinaryTree {
  // lc-987. Vertical Order Traversal of a Binary Tree

    public void build(List<int[]>list,TreeNode root,int i,int j){
        if(root==null)return;
        list.add(new int[]{root.val,i,j});
        build(list,root.left,i+1,j-1);
        build(list,root.right,i+1,j+1);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]>list=new ArrayList<>();
        build(list,root,0,0);
        Collections.sort(list,(a,b)->{
            if(a[2]==b[2]){
                if(a[1]==b[1]){
                    return Integer.compare(a[0],b[0]);
                }
                return Integer.compare(a[1],b[1]);
            }
            return Integer.compare(a[2],b[2]);
        });
        List<List<Integer>> ans=new ArrayList<>();
        int j=list.get(0)[2];
        ans.add(new ArrayList<>());
        ans.get(0).add(list.get(0)[0]);
        for(int i=1;i<list.size();i++){
            if(j==list.get(i)[2]){
                ans.get(ans.size()-1).add(list.get(i)[0]);
            }else{
                j=list.get(i)[2];
                ans.add(new ArrayList<>());
                ans.get(ans.size()-1).add(list.get(i)[0]);
            }
        }
        return ans;       
    }
}
