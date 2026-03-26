package DepthSearchFirst;

public class BurningTree {

    int maxTime=0;
    private int solve(TreeNode root,int start){
        if(root==null)return 0;
        int left=solve(root.left,start);
        int right=solve(root.right,start);

        if(root.val==start){
            maxTime=Math.max(left,right);
            return -1;
        }
        if(left<0){//left tree me infection
            maxTime=Math.max(maxTime,Math.abs(left)+right);
            return left-1;
        }
        if(right<0){
            maxTime=Math.max(maxTime,Math.abs(right)+left);
            return right-1;
        }
        return Math.max(left,right)+1;
    }
    public int amountOfTime(TreeNode root, int start) {
        solve(root,start);
        return maxTime;
    }
}

