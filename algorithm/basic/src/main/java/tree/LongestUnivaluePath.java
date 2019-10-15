package tree;

/**
 * @author cvictory ON 2019-07-25
 */
public class LongestUnivaluePath {

    int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(searchLongestUnivaluePath(root), Math.max(longestUnivaluePath(root.left), longestUnivaluePath(root.right)));
    }

    public int searchLongestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = searchLongestUnivaluePath(root.left);
        int right = searchLongestUnivaluePath(root.right);
//        if (root.left != null && root.left.val == root.val) {
//            v += searchLongestUnivaluePath(root.left);
//        }
//        if (root.right != null && root.right.val == root.val) {
//            v += searchLongestUnivaluePath(root.right);
//        }
        return 0;
    }
}
