package BreadthFirstSearch;

public class WordLadder {
  // lc-127. Word Ladder
    public void fill(String s,HashSet<String>words,HashSet<String>visited,Queue<String> q){
        int n=s.length();
        for(int i=0;i<n;i++){
            StringBuilder sb=new StringBuilder(s);
            for(int k=1;k<=25;k++){
                int ch=sb.charAt(i)-'a';
                char c=(char)((ch+k)%26+'a');
                sb.setCharAt(i,c);
                String next=sb.toString();
                if(words.contains(next)&& !visited.contains(next)){
                    q.add(next);
                    visited.add(next);
                }
                sb=new StringBuilder(s);
            }
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String>words=new HashSet<>();
        for(String s:wordList)words.add(s);
        HashSet<String>visited=new HashSet<>();
        Queue<String> q=new ArrayDeque<>();
        if(!words.contains(endWord)) return 0;
        q.add(beginWord);
        visited.add(beginWord);
        int level=1;
        while(!q.isEmpty()){
            int size=q.size();
            while(size>0){
                String s=q.remove();
                if(s.equals(endWord))return level;
                fill(s,words,visited,q);
                size--;
            }
            level++;
        }
        return 0;
    }  
}