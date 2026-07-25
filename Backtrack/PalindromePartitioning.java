class Solution {
  // lc-131. Palindrome Partitioning
    boolean valid(int i,int j,String s){
        if(i==j)return true;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))return false;
            i++;j--;
        }
        return true;
    }
    void solve(String s,int i,List<List<String>>ans,List<String>temp){
        if(i==s.length()){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int k=i;k<s.length();k++){
            if(valid(i,k,s)){
                temp.add(s.substring(i,k+1));
                solve(s,k+1,ans,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        solve(s,0,ans,new ArrayList<>());
        return ans;
    }
}