/**
 * Author: ������
 * Date: 2015-08-21
 * Time: 19:02
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * ԭ��
     * Given a binary tree, flatten it to a linked list in-place.
     * For example,
     * Given
     *
     *      1
     *     / \
     *    2   5
     *   / \   \
     *  3   4   6
     *
     * The flattened tree should look like:
     *
     * 1
     *  \
     *   2
     *    \
     *     3
     *      \
     *       4
     *        \
     *         5
     *          \
     *           6
     *
     * ��Ŀ����
     * ����һ�ö�����������ת�ɵ�����ʹ��ԭ���㷨��
     *
     * ����˼·
     * �Ӹ���㣨root������������l���������ӽ�㣨x������root����������r���ӵ�x���������ϣ�x��������Ϊ�գ���
     * root���������������Ϊ��������root�����������ա�
     * </pre>
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        TreeNode head = new TreeNode(-1);
        head.right = root;
        TreeNode node = head;

        while (node.right != null) {
            node = node.right;
            if (node.left != null) {
                TreeNode end = node.left;
                while (end.right != null) {
                    end = end.right;
                }

                TreeNode tmp = node.right;

                node.right = node.left;
                node.left = null;
                end.right = tmp;
            }
        }

        head.right = null; // ȥ�����÷�����������
    }
}
