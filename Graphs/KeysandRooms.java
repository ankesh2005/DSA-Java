package Graphs;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class KeysandRooms {
   //lc-841 Keys and Rooms
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visit=new boolean[rooms.size()];
        Queue<Integer> q=new ArrayDeque<>();
        q.add(0);
        while(!q.isEmpty()){
            int room=q.remove();
            visit[room]=true;
            List<Integer>keys=rooms.get(room);
            for(int key:keys){
                if(!visit[key])q.add(key);
            }
        }
        for(int i=0;i<rooms.size();i++){
            if(!visit[i])return false;
        }
        return true;
    }

    public void dfs(List<List<Integer>> rooms,boolean[] visit,int i){
        for(int key:rooms.get(i)){
            if(!visit[key]){
                visit[key]=true;
                dfs(rooms,visit,key);
            }
        }
    }
    public boolean canVisitAllRooms1(List<List<Integer>> rooms) {
        boolean visit[]=new boolean[rooms.size()];
        visit[0]=true;
        dfs(rooms,visit,0);
        for(int i=0;i<rooms.size();i++){
            if(!visit[i])return false;
        }
        return true;
    }
}
