package leetcode;
public class MatrixSimilarityAfterCyclicShifts {
  // lc-2946. Matrix Similarity After Cyclic Shifts
   public boolean areSimilar(int[][] mat, int k) {
        int n=mat[0].length;
        k%=n;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<n;j++){
                int future;
                if(i%2==0){
                    future=(j+k)%n;
                }
                else{
                    future=(j-k+n)%n;
                }
                if(mat[i][future]!=mat[i][j])return false;
            }  
        }
        return true;
    }
}