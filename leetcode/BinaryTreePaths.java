public class BinaryTreePaths {
  /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  // lc-257
    private void path(TreeNode root,List<String> ans,StringBuilder temp){
        if(root==null) return;
        int len=temp.length();
        if(len!=0) temp.append("->");
        temp.append(root.val);
        if(root.left==null && root.right==null){
            ans.add(new String(temp.toString()));
        }else{
            path(root.left,ans,temp);
            path(root.right,ans,temp);
        }
        temp.setLength(len);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans=new ArrayList<>();
        path(root,ans,new StringBuilder());
        return ans;
    }
}
}
