package tree;

/**
 * @author cvictory ON 2019-06-01
 */
public class SubtreeAnotherTree {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        boolean result = checkSubtree(s, t);
        return result || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean checkSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        }
        return checkSubtree(s.left, t.left) && checkSubtree(s.right, t.right);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
