
public class kthLargest {
    /**
     * 剑指 Offer 54. 二叉搜索树的第k大节点
     * <p>
     * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
     * <p>
     * 示例 1:
     * <p>
     * 输入: root = [3,1,4,null,2], k = 1
     * 3
     * / \
     * 1   4
     * \
     * 2
     * 输出: 4
     *
     * 题解： 搜索二叉树的中序遍历（左-根-右）的倒叙  右-根-左，遍历出来后就是倒叙排列（从大到小），所以第k大就是倒序排列的第k个值
     */



    private int ans = 0, cnt = 0;

    public int Solution(TreeNode root, int k) {
        dfs(root, k);
        return ans;
    }

    private void dfs(TreeNode root, int k) {
        if (root == null) return;
        dfs(root.right, k);
        if (++cnt == k) {
            ans = root.val;
            return;
        }
        dfs(root.left, k);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
