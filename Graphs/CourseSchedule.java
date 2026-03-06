package Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class CourseSchedule {
  //lc-207 Course Schedule
  class Solution {
    public void bfs(int[] indegree,ArrayList<ArrayList<Integer>>adj,ArrayList<Integer>ans){
        Queue<Integer> q=new ArrayDeque<>();
        int n=indegree.length;
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(q.size()>0){
            int curr=q.remove();
            ans.add(curr);
            for(int ver:adj.get(curr)){
                indegree[ver]--;
                if(indegree[ver]==0)q.add(ver);
            }
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree=new int[numCourses];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++)adj.add(new ArrayList<>());
        for(int[] temp:prerequisites){
          int a=temp[1];
          int b=temp[0];
          indegree[b]++;
          adj.get(a).add(b);
        }
        ArrayList<Integer> ans=new ArrayList<>();
        bfs(indegree,adj,ans);
        return ans.size()==numCourses;
    }
}
        
}
