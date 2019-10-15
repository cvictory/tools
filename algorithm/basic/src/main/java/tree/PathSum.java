package tree;

/**
 * @author cvictory ON 2019-06-01
 */
public class PathSum {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return pathSum(root.left, sum) + pathSum(root.right, sum) + doPathSum(root, sum);
    }

    private int doPathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int ret = 0;
        if (sum == root.val) {
            ret++;
        }
        return ret + doPathSum(root.left, sum - root.val) + doPathSum(root.right, sum - root.val);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public int pathSum2(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        if(root.val == sum){
            return 1;
        }

        return pathSum2(root.left, sum - root.val) + pathSum(root.right, sum - root.val) + pathSum2(root.left, sum) + pathSum2(root.right, sum);
    }

}
