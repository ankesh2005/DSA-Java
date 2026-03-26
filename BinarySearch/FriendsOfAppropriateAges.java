public package BinarySearch;

class FriendsOfAppropriateAges {
  // lc-825. Friends Of Appropriate Ages
  class Solution {
    public int numFriendRequests(int[] ages) {
        int req=0;
        int[] count=new int[121];
        for(int age:ages){
            count[age]++;
        }
        for(int i=1;i<121;i++){
            if(count[i]==0)continue;
            if(i<15)continue;
            req+=(count[i])*(count[i]-1);
            int min=(int)Math.ceil(i*.5+7);
            for(int j=i-1;j>=1;j--){
                if(count[j]==0)continue;
                if(j<min)break;
                if(j>.5*i+7){
                    req+=(count[i]*count[j]);
                }
            }
        }
        return req;
    }
    public int numFriendRequests1(int[] ages) {
        Arrays.sort(ages);
        int req=0;
        int n=ages.length;
        for(int x=1;x<n;x++){
            double min=.5*ages[x]+7;
            int y=x-1;
            while(y>=0 && min<ages[y] ){
            if(ages[x]==ages[y])req+=2;
            else req++;
            y--;
            }
        }
        return req;
    }
}
}