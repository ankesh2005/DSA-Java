package DSU;

public class LexicographicallySmallestEquivalentString {
  // lc-1061. Lexicographically Smallest Equivalent String
  class Solution {
    public char find(char ch,char[] parent){
        if(parent[ch-'a']==ch)return ch;
        return parent[ch-'a']=find(parent[ch-'a'],parent);
    }
    public void union(char a,char b,char[] parent){
        char leadA=find(a,parent);
        char leadB=find(b,parent);
        if(leadA!=leadB){
            if(leadA<leadB){
                parent[leadB-'a']=leadA;
            }else{
                parent[leadA-'a']=leadB;
            }
        }
    }
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        char[] parent=new char[26];
        for(int i=0;i<26;i++){
            parent[i]=(char)(i+'a');
        }
        for(int i=0;i<s1.length();i++){
            union(s1.charAt(i),s2.charAt(i),parent);
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<baseStr.length();i++){
            sb.append(find(baseStr.charAt(i),parent));
        }
        return sb.toString();
    }
}
}
