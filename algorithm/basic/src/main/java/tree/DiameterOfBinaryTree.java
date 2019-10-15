package tree;

/**
 * @author cvictory ON 2019-07-24
 */
public class DiameterOfBinaryTree {

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxPath(root);
        return max;
    }

    private int maxPath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = maxPath(root.left);
        int r = maxPath(root.right);
        max = Math.max(max, l + r + 1);
        return Math.max(l, r) + 1;
    }
}
