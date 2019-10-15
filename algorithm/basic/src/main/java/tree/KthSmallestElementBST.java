package tree;

/**
 * @author cvictory ON 2019-06-01
 */
public class KthSmallestElementBST {

    int val, cnt;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        int left = kthSmallest(root.left, k);
        if (left + 1 == k) {
            val = root.val;
            return k;
        } else if (left == k) {
            return k;
        }
        int rightCnt = k - left - 1;
        int right = kthSmallest(root.right, rightCnt);
        if (right == rightCnt) {
            return k;
        }
        return -1;
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
