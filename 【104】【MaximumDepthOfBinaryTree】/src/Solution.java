/**
 * Author: ������
 * Date: 2015-08-21
 * Time: 18:47
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * ԭ��
     * Given a binary tree, find its maximum depth.
     * The maximum depth is the number of nodes along the longest path
     * from the root node down to the farthest leaf node.
     *
     * ��Ŀ����
     * ����һ���������������������ȡ�
     *
     * ����˼·
     * �ݹ���⣬�ݹ鹫ʽ
     * f(n) = 0; n=null,
     * f(n) = 1+ max(f(n��)�� f(n��))
     * </pre>
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        } else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return 1 + (left > right ? left : right);
        }
    }
}
