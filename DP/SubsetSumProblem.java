public class SubsetSumProblem {
    static boolean solve(int[] arr,int[][] dp,int sum,int idx){
        if(sum==0)return true;
        if(idx==0 )return sum==arr[0];
        if (sum < 0) return false;
        if(dp[idx][sum]!=-1)return dp[idx][sum]==1;
        boolean take=solve(arr,dp,sum-arr[idx],idx-1);
        boolean skip=solve(arr,dp,sum,idx-1);
        dp[idx][sum]=(take||skip)==true?1:0;
        return dp[idx][sum]==1;
    }
    static Boolean isSubsetSum(int arr[], int sum) {
        // int[][] dp=new int[arr.length][sum+1];
        // for(int[] row:dp)Arrays.fill(row,-1);
        // return solve(arr,dp,sum,arr.length-1);
        
        int n=arr.length;
        boolean[][] dp=new boolean[n][sum+1];
        for(int i=0;i<n;i++){
            dp[i][0]=true;
        }
        if (arr[0] <= sum) dp[0][arr[0]]=true;
        for(int i=1;i<n;i++){
            for(int j=1;j<=sum;j++){
                boolean skip=dp[i-1][j];
                boolean take=false;
                if(arr[i]<=j)take=dp[i-1][j-arr[i]];
                
                dp[i][j]=skip||take;
            }
        }
        return dp[n-1][sum];
    }
}
