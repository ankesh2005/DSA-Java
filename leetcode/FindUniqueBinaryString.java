import java.util.HashSet;

public class FindUniqueBinaryString {
//lc-1980 Find Unique Binary String
  class Solution {
    static String ans;
    static boolean found;
    public void recursion(StringBuilder sb,HashSet<String>set){
        if(found)return;
        if(sb.length()>set.size())return;
        if(sb.length()==set.size()){
            if(!set.contains(sb.toString())){
                ans=sb.toString();
                found=true;
                return;
            }
        }

        recursion(sb.append('0'),set);
        sb.deleteCharAt(sb.length()-1);
        recursion(sb.append('1'),set);
        sb.deleteCharAt(sb.length()-1);
    }
    public String findDifferentBinaryString(String[] nums) {
        // StringBuilder sb=new StringBuilder();
        // for(int i=0;i<nums.length;i++){
        //     String s=nums[i];
        //     int ch=s.charAt(i)-'0';
        //     sb.append(ch^1);
        // }
        // return sb.toString();
        ans="";
        found=false;
        HashSet<String>set=new HashSet<>();
        for(String s:nums)set.add(s);
        recursion(new StringBuilder(),set);
        return ans;
    }
}
}