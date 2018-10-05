/**
 * Author: ������
 * Date: 2015-06-25
 * Time: 09:00
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    // ��¼����·����
    private int max;
    // ��¼��ǰ��·����
    private int cur;

    /**
     * <pre>
     * Given a binary tree, find the maximum path sum.
     * The path may start and end at any node in the tree.
     * For example:
     * Given the below binary tree,
     *   1
     *  / \
     * 2   3
     * Return 6.
     *
     * ��Ŀ���⣺
     * �������������·���ͣ�·������ʼ���յ������������
     *
     *
     * </pre>
     *
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {


        if (root == null) {
            throw new IllegalArgumentException();
        }

        max = Integer.MIN_VALUE;
        cur = 0;
        maxPathSumHelper(root);
        return max;
    }

    public void maxPathSumHelper(TreeNode root) {
        if (root != null) {
            cur += root.val;

            if (max < cur) {
                max = cur;
            }

            maxPathSumHelper(root.left);
            maxPathSumHelper(root.right);
        }
    }

}
