package Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class RobotCollisions {
  // lc-2751. Robot Collisions
  public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        int[][] robots = new int[n][4]; // pos, health, dir, index
        for (int i = 0; i < n; i++) {
            robots[i][0] = positions[i];
            robots[i][1] = healths[i];
            robots[i][2] = directions.charAt(i) == 'R' ? 1 : -1;
            robots[i][3] = i;
        }
        Arrays.sort(robots, (a, b) -> a[0] - b[0]);
        Stack<int[]> stack = new Stack<>();
        for (int[] robot : robots) {
            if (robot[2] == 1) { // moving right
                stack.push(robot);
            } else { // moving left
                while (!stack.isEmpty() && stack.peek()[2] == 1 && robot[1] > 0) {
                    int[] top = stack.peek();
                    if (top[1] == robot[1]) {
                        stack.pop();
                        robot[1] = 0; // both destroyed
                        break;
                    } else if (top[1] > robot[1]) {
                        top[1]--; // right robot survives, loses 1
                        robot[1] = 0; // left robot dies
                        break;
                    } else {
                        stack.pop(); // right robot dies
                        robot[1]--; // left robot survives, loses 1
                    }
                }
                if (robot[1] > 0)
                    stack.push(robot);
            }
        }// Collect survivors in original order
        Map<Integer, Integer> survivors = new HashMap<>();
        for (int[] r : stack) {
            survivors.put(r[3], r[1]);
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (survivors.containsKey(i)) ans.add(survivors.get(i));
        }
        return ans;


    }
}
