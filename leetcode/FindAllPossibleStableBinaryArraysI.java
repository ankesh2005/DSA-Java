public class FindAllPossibleStableBinaryArraysI {
  //lc-3129. Find All Possible Stable Binary Arrays I
  class Solution {
    static int MOD=(int)1E9+7;
    int[][][] dp;
    public int solve(int  zeroleft,int oneleft,boolean lastdigit,int limit){
        if(zeroleft==0 && oneleft==0)return 1;
        int idx = lastdigit ? 1 : 0;
        if(dp[zeroleft][oneleft][idx]!=-1)return dp[zeroleft][oneleft][idx];
        int result=0;
        if(lastdigit==true){
            for(int i=1;i<=Math.min(limit,zeroleft);i++){
                result=(result+solve(zeroleft-i,oneleft,false,limit))%MOD;
                
            }
        }
        else{
            for(int i=1;i<=Math.min(limit,oneleft);i++){
                result=(result+solve(zeroleft,oneleft-i,true,limit))%MOD;
            }
        }
        return dp[zeroleft][oneleft][idx]=result%MOD;
    }
    public int numberOfStableArrays(int zero, int one, int limit) {
        dp=new int[zero+1][one+1][2];
        // for(int i=0;i<=zero;i++){
        //     for(int j=0;j<=one;j++){
        //         for(int k=0;k<2;k++){
        //             dp[i][j][k]=-1;
        //         }
        //     }
        // }
        // int onestart=solve(zero,one,false,limit);
        // int zerostart=solve(zero,one,true,limit);
        dp[0][0][0]=1;
        dp[0][0][1]=1;
        for(int i=0;i<=zero;i++){
            for(int j=0;j<=one;j++){
                if(i==0 && j==0)continue;
                int result=0;
                for(int con=1;con<=Math.min(i,limit);con++){//last digit was one
                    result+=dp[i-con][j][1];
                    result=result%MOD;
                }
                dp[i][j][0]=result;
                result=0;
                for(int con=1;con<=Math.min(j,limit);con++){//last digit was zero
                    result+=dp[i][j-con][0];
                    result=result%MOD;
                }
                dp[i][j][1]=result;
            }
        }
        // return (zerostart+onestart)%MOD
        return (dp[zero][one][0]+dp[zero][one][1])%MOD;
    }
}
}