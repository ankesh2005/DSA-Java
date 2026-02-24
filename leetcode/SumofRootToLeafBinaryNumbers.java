import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class SumofRootToLeafBinaryNumbers {
  /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static int sum;

    private static void leaf(TreeNode root, StringBuilder sb) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            sum += Integer.parseInt(sb.toString(), 2);
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        sb.append(root.val);
        leaf(root.left, sb);
        leaf(root.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }

    public int sumRootToLeaf(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        sum = 0;
        leaf(root, new StringBuilder());
        return sum;
    }
}
}
