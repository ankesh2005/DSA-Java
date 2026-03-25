package SlindingWindow;

public class GrumpyBookstoreOwner {
  //lc-1052. Grumpy Bookstore Owner
  class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int base=0;
        int n=customers.length;
        for(int i=0;i<n;i++){
            base+=customers[i]*(1-grumpy[i]);
        }
        int gain=0,max=0;
        for(int i=0;i<minutes;i++){
            if(grumpy[i]==1){
                gain+=customers[i];
            }
            max=Math.max(max,gain);
        }
        for(int i=0;i<n-minutes;i++){
            if(grumpy[i+minutes]==1){
                gain+=customers[i+minutes];
            }
            if(grumpy[i]==1){
                gain-=customers[i];
            }
            max=Math.max(gain,max);
        }
        return base+max;
    }
}
}
