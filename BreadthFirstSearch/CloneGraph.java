package BreadthFirstSearch;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import org.w3c.dom.Node;

public class CloneGraph {
  // lc-133. Clone Graph

  class Solution {
    public void dfs(Node node, Node clone, Map<Node, Node> map) {
      for (Node n : node.neighbors) {
        if (!map.containsKey(n)) {
          Node newClone = new Node(n.val);
          clone.neighbors.add(newClone);
          map.put(n, newClone);
          dfs(n, newClone, map);
        } else {
          clone.neighbors.add(map.get(n));
        }
      }
    }

    void bfs(Node node, Node clone, Map<Node, Node> map) {
      Queue<Node[]> q = new ArrayDeque<>();
      q.add(new Node[] { node, clone });
      while (!q.isEmpty()) {
        Node pair[] = q.poll();
        Node parent = pair[0];
        Node cloneParent = pair[1];
        for (Node n : parent.neighbors) {
          if (!map.containsKey(n)) {
            Node newClone = new Node(n.val);
            cloneParent.neighbors.add(newClone);
            map.put(n, newClone);
            q.add(new Node[] { n, newClone });
          } else {
            cloneParent.neighbors.add(map.get(n));
          }
        }
      }
    }

    public Node cloneGraph(Node node) {
      Map<Node, Node> map = new HashMap<>();
      if (node == null)
        return null;
      Node clone = new Node(node.val);
      map.put(node, clone);
      // dfs(node,clone,map);
      bfs(node, clone, map);
      return clone;
    }
  }

}