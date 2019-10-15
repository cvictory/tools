package tree;

/**
 * @author cvictory ON 2019-07-25
 */
public class KthSmallest {

    int cnt = 0;
    int r = -1;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        System.out.println("--" + root.val);
        kthSmallest(root.left, k);
        cnt ++;
        if (cnt == k) {
            r = root.val;
            System.out.println("**" + root.val);
            return 0;
        }

        kthSmallest(root.right, k);
        return -1;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(1);
        node.right = new TreeNode(4);
        node.left.right = new TreeNode(2);
        KthSmallest smallest =  new KthSmallest();
        smallest.kthSmallest(node, 1);
        System.out.println(smallest.r);


        node = new TreeNode(5);
        node.left = new TreeNode(3);
        node.right = new TreeNode(6);
        node.left.left = new TreeNode(2);
        node.left.right = new TreeNode(4);
        node.left.left.left = new TreeNode(1);
        smallest =  new KthSmallest();
        smallest.kthSmallest(node, 3);
        System.out.println(smallest.r);
    }
}
