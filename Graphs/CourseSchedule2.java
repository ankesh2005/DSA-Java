package Graphs;

import java.util.ArrayList;
import java.util.Collections;

public class CourseSchedule2 {
 //lc-210 Course Schedule 2
 class Solution {
    public boolean dfs(int i, ArrayList<ArrayList<Integer>> adj, int[] visit, ArrayList<Integer> ans) {
        visit[i] = 1;//visiting
        for (int v : adj.get(i)) {
            if (visit[v]==1)return true;//cycle
            if (visit[v] == 0 && dfs(v, adj, visit, ans)) return true;
        }
        visit[i]=2;//visited
        ans.add(i);
        return false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int visit[] = new int[numCourses];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)  adj.add(new ArrayList<>());
        for (int[] edge : prerequisites)  adj.get(edge[1]).add(edge[0]);
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (visit[i]==0 && dfs(i,adj,visit,ans)){
                return new int[0];
            }
        }

        Collections.reverse(ans);
        int[] arr = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++)  arr[i] = ans.get(i);
        return arr;
    }
}
}
