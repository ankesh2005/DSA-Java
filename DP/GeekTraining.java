package Dp;
public class GeekTraining {

  public int maximumPoints(int mat[][]) {
        int prev[]=mat[0];
        int n=mat.length;
        for(int i=1;i<n;i++){
            int[] temp=mat[i];
            int[] curr = new int[3]; 
            for(int j=0;j<3;j++){
                int max=0;
                for(int k=0;k<3;k++){
                    if(k==j)continue;
                    max=Math.max(prev[k]+temp[j],max);
                }
                curr[j]=max;
            }
            prev=curr;
        }
        return Math.max(prev[0],Math.max(prev[1],prev[2]));
    }
  
}