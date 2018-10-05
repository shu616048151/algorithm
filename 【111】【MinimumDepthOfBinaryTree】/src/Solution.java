/**
 * Author: ������
 * Date: 2015-08-21
 * Time: 18:51
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    private int min = Integer.MAX_VALUE; // ��¼������С���
    private int cur = 0; // i��ǰ��������ĳ���

    /**
     * <pre>
     * ԭ��
     * Given a binary tree, find its minimum depth.
     * The minimum depth is the number of nodes along the shortest path from
     * the root node down to the nearest leaf node.
     *
     * ��Ŀ����
     * ����һ����������������С��ȡ�
     *
     * ����˼·
     * �������������������б������ҳ���С����ȡ�
     * </pre>
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {

        depth(root);
        return min;
    }

    /**
     * �����������
     *
     * @param node ��ǰ���
     */
    private void depth(TreeNode node) {

        if (node == null) {
            min = cur;
            return;
        }

        cur++; // ��ǰ����Ĳ�μ�1
        // �����Ҷ�ڵ㣬����·���ȼ�¼����С��С
        if (node.left == null && node.right == null && cur < min) {
            min = cur; // ������Сֵ
        }
        // ����������
        if (node.left != null) {
            depth(node.left);
        }

        // ����������
        if (node.right != null) {
            depth(node.right);
        }

        cur--; // ��ԭ

    }
}
