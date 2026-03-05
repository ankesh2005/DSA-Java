import java.util.ArrayList;

class BitsManipulate{
  // lc-136 Single Number
  public int singleNumber(int[] nums) {
        int result=0;
        for(int num:nums) result^=num;
        return result;
    }

    // swap 2 numbers{
    public void swap(int a,int b){
      a=a^b;
      b=b^a;
      a=a^b;
    }
    // check kth bit 
    static boolean checkKthBit(int n, int k) {
        n=n>>k;
        return n%2==0?false:true;
    }

    // set kth bit
    static int setKthBit(int n, int k) {
        int mask=1<<k;
        n=n|mask;
        return n; 
    }
    // clear kth bit
    static int clearKthBit(int n,int k){
      int mask=~(1<<k);//1s compliment get us to 111101111 some thing like this
      return n&mask;
    }

    // toggle kth bit
    static int toggleKthBit(int n,int k){
      int mask=(1<<k);
      return n^mask;
    }
    // rightmost set bit
    static int rmSetBit(int n){
      // return n|(n+1);
      for(int i=0;i<31;i++){
        if((n>>i)%2==0){
          return n|1<<i;
        }
      }
      return 1;
    }
    // lc-231 power of two
    public boolean isPowerOfTwo(int n) {
        if(n<0)return false;
        int bits=Integer.bitCount(n);
        return bits==1?true:false;
    }
    // lc-191 Number of 1 bits
    static int setBits(int n) {
        // return Integer.bitCount(n);
        int ans=0;
        for(int i=0;i<31;i++){
            if((n>>i)%2!=0)ans++;
        }
        return ans;
    }
    // lc-78 subsets
    public ArrayList<ArrayList<Integer>> subsets(int arr[]) {
        int n=arr.length;
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        for(int mask=0;mask<(1<<n);mask++){
            ArrayList<Integer> temp=new ArrayList<>();
            for(int i=0;i<n;i++){
                if(((1<<i)&mask)!=0)temp.add(arr[i]);
            }
            ans.add(temp);
        }
        return ans;
    }
    // lc-342 Power of four
    int isPowerOfFour(long n) {
        long root=(long)Math.sqrt(n);
        boolean isSqr=root*root==n;
        boolean ispow2=(n&(n-1))==0;
        return isSqr&&ispow2==true?1:0;
    }

    // Find XOR of numbers from L to R.
    public static int Xor(int n){
        if(n%4==1)return 1;
        else if(n%4==2)return n+1;
        else if(n%4==3)return 0;
        else return n;
    }
    public static int findXOR(int l, int r) {
        // 1^2^3^4^5^6^7^8^1^2^3
        return Xor(l-1)^Xor(r);
        
    }

    public static void main(String[] args) {
      System.out.println(~5);//1's compilement or -5-1
      System.out.println(~5+1);//2's compilement or -5
    }
}