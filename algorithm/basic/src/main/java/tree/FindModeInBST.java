package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cvictory ON 2019-06-02
 */
public class FindModeInBST {

    int curMax;
    int max = Integer.MIN_VALUE;
    TreeNode prevNode;
    List<Integer> result = new ArrayList<Integer>();

    public int[] findMode(TreeNode root) {
        doFindMode(root);
        int[] rr = new int[result.size()];
        int c = 0;
        for (Integer r : result) {
            rr[c++] = r;
        }
        return rr;
    }

    private void doFindMode(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        doFindMode(treeNode.left);

        if (prevNode != null) {
            if (prevNode.val == treeNode.val) {
                curMax++;
            } else {
                curMax = 1;
            }
        }
        if (curMax > max) {
            max = curMax;
            result.clear();
            result.add(treeNode.val);
        } else if (curMax == max) {
            result.add(treeNode.val);
        }
        prevNode = treeNode;

        doFindMode(treeNode.right);
    }


}
