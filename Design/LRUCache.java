package Design;

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Node;

public class LRUCache {
  // lc-146. LRU Cache
  class Node {
    Node left;
    int key, val;
    Node right;

    Node(int key, int val) {
      this.val = val;
      left = null;
      right = null;
      this.key = key;
    }
  }

  Node head, tail;
  int n;
  Map<Integer, Node> map = new HashMap<>();

  public LRUCache(int capacity) {
    n = capacity;
    head = new Node(0, 0);
    tail = new Node(0, 0);
    head.right = tail;
    tail.left = head;
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      Node curr = map.get(key);
      int val = curr.val;
      remove(curr);
      insert(curr);
      return val;
    }
    return -1;
  }

  public void put(int key, int value) {
    if (map.containsKey(key)) {
      Node curr = map.get(key);
      curr.val = value;
      remove(curr);
      insert(curr);
    } else {
      if (map.size() == n) {
        Node lru = head.right;
        remove(lru);
        map.remove(lru.key);
      }
      Node node = new Node(key, value);
      insert(node);
      map.put(key, node);

    }
  }

  void insert(Node node) {
    Node last = tail.left;
    last.right = node;
    node.right = tail;
    tail.left = node;
    node.left = last;
  }

  void remove(Node node) {
    node.left.right = node.right;
    node.right.left = node.left;
  }
}
