package tree;

/**
 * @author cvictory ON 2019-06-02
 */
public class ConvertSortedArray2Tree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return doSortedArrayToBST(nums, 0, nums.length);
    }

    public TreeNode doSortedArrayToBST(int[] nums, int start, int length) {
        if (length <= 0) {
            return null;
        }
        int rootPos = start + length / 2 + 1;
        System.out.println(rootPos + " : " + nums[rootPos - 1] + " ; " + start + ", " + length);
        TreeNode treeNode = new TreeNode(nums[rootPos - 1]);
        TreeNode leftTree = doSortedArrayToBST(nums, start, length / 2);
        TreeNode rightTree = doSortedArrayToBST(nums, rootPos, (length - 1) / 2);
        treeNode.left = leftTree;
        treeNode.right = rightTree;
        return treeNode;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public static void main(String[] args) {
        System.out.println(new ConvertSortedArray2Tree().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
    }
}
