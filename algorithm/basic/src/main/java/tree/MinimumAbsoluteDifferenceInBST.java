package tree;

/**
 * @author cvictory ON 2019-06-02
 */
public class MinimumAbsoluteDifferenceInBST {
    private int minPath = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        doCaculate(root.left, root.val);
        doCaculate(root.right, root.val);
        return minPath;
    }

    private void doCaculate(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        doCaculate(root.left, root.val);
        minPath = Math.min(minPath, Math.abs(val - root.val));
        doCaculate(root.right, root.val);
    }

}
