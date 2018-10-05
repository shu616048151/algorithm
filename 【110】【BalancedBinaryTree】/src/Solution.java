/**
 * Author: ������
 * Date: 2015-08-21
 * Time: 18:53
 * Declaration: All Rights Reserved !!!
 */
public class Solution {

    /**
     * <pre>
     * ԭ��
     * Given a binary tree, determine if it is height-balanced.
     * For this problem, a height-balanced binary tree is defined as a binary tree
     * in which the depth of the two subtrees of every node never differ by more than 1.
     *
     * ��Ŀ����
     * ����һ��ƽ����������ж����Ƿ��Ǹ߶�ƽ��ġ�һ�ø߶�ƽ��Ķ����������������ĸ߶�������1��
     * ������������Ҳ����ˡ�
     *
     * ����˼·
     * �ݹ���η���⡣
     * </pre>
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }

        int left = depth(root.left);
        int right = depth(root.right);
        if (left - right > 1 || left - right < -1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    /**
     * �����ĸ߶�
     *
     * @param n ���ĸ����
     * @return ���ĸ߶�
     */
    private int depth(TreeNode n) {
        if (n == null) {
            return 0;
        }
        if (n.left == null && n.right == null) {
            return 1;
        } else {
            int left = depth(n.left);
            int right = depth(n.right);
            return 1 + (left > right ? left : right);
        }
    }

}
