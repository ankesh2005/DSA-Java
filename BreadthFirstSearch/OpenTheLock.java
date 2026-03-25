package BreadthFirstSearch;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

public class OpenTheLock {
  // lc-752. Open the Lock

    public void fill(Queue<String> q,HashSet<String> dead,String s){
        for(int i=0;i<4;i++){
            StringBuilder sb=new StringBuilder(s);
            int ch=sb.charAt(i)-'0';
            int inc=ch==9?0:ch+1;
            int dec=ch==0?9:ch-1;
            sb.setCharAt(i,(char)(inc+'0'));
            if(!dead.contains(sb.toString())){
                dead.add(sb.toString());
                q.add(sb.toString());
            }
            sb.setCharAt(i,(char)(dec+'0'));
            if(!dead.contains(sb.toString())){
                dead.add(sb.toString());
                q.add(sb.toString());
            }
        }
    }
    public int openLock(String[] deadends, String target) {
        HashSet<String> dead=new HashSet<>();
        for(int i=0;i<deadends.length;i++){
            dead.add(deadends[i]);
        }
        StringBuilder sb=new StringBuilder("0000");
        Queue<String> q=new ArrayDeque<>();
        if(dead.contains(sb.toString()))return -1;
        q.add(sb.toString());
        q.add(sb.toString());
        int level=0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size>0){
                String s=q.remove();    
                if(target.equals(s))return level;
                fill(q,dead,s);
                size--;
            }
            level++;
        }
        return -1;

    }
}
