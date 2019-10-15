package tree;

/**
 * @author cvictory ON 2019-07-24
 */
public class IsBalanced {
    boolean isBalance = true;

    public boolean isBalanced(TreeNode root) {
        max(root);
        return isBalance;
    }

    private int max(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sub = Math.abs(max(root.left) - max(root.right));
        if (sub > 1) {
            isBalance = false;
        }
        return 1 + Math.max(max(root.left), max(root.right));
    }
}
