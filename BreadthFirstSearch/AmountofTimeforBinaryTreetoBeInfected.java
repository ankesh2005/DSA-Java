package BreadthFirstSearch;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AmountofTimeforBinaryTreetoBeInfected {
  //lc-2385. Amount of Time for Binary Tree to Be Infected
    public void buildGraph(TreeNode node,TreeNode parent,Map<Integer,List<Integer>> graph){
        if(node==null)return;
        graph.putIfAbsent(node.val,new ArrayList<>());
        if(parent!=null){
            graph.get(parent.val).add(node.val);
            graph.get(node.val).add(parent.val);
        }
        buildGraph(node.left,node,graph);
        buildGraph(node.right,node,graph);
    }
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer,List<Integer>> graph=new HashMap<>();
        buildGraph(root,null,graph);
        Queue<Integer>q=new ArrayDeque<>();
        Set<Integer>visited=new HashSet<>();
        int level=0;
        q.add(start);
        visited.add(start);
        while(!q.isEmpty()){
            int size=q.size();
            while(size>0){
                int u=q.poll();
                for(int v:graph.get(u)){
                    if(!visited.contains(v)){
                        visited.add(v);
                        q.add(v);
                    }
                }
                size--;
            }
            level++;
        }
        return level-1;
    }
}
