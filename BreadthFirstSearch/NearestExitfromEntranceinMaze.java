package BreadthFirstSearch;

import java.util.ArrayDeque;
import java.util.Queue;

public class NearestExitfromEntranceinMaze {
  // lc-1926. Nearest Exit from Entrance in Maze
  class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
      Queue<int[]> q = new ArrayDeque<>();
      int ans = 0;
      int r = maze.length;
      int c = maze[0].length;
      q.add(entrance);
      int level = 0;
      maze[entrance[0]][entrance[1]] = '+';
      while (!q.isEmpty()) {
        int size = q.size();
        for (int i = 0; i < size; i++) {
          int[] point = q.poll();
          int px = point[0];
          int py = point[1];
          if ((px == 0 || py == 0 || px == r - 1 || py == c - 1)
              && !(px == entrance[0] && py == entrance[1])) {
            return level;
          }
          // up
          if (px - 1 >= 0 && maze[px - 1][py] == '.') {
            maze[px - 1][py] = '+';
            q.add(new int[] { px - 1, py });

          }
          // down
          if (px + 1 < r && maze[px + 1][py] == '.') {
            maze[px + 1][py] = '+';
            q.add(new int[] { px + 1, py });
          }
          // left
          if (py - 1 >= 0 && maze[px][py - 1] == '.') {
            maze[px][py - 1] = '+';
            q.add(new int[] { px, py - 1 });
          }
          // right
          if (py + 1 < c && maze[px][py + 1] == '.') {
            maze[px][py + 1] = '+';
            q.add(new int[] { px, py + 1 });
          }
        }
        level++;
      }
      return -1;
    }
  }
}
