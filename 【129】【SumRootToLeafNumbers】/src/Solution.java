/**
 * Author: ������
 * Date: 2015-08-21
 * Time: 19:13
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    private int result = 0; // ��¼�ܵĽ��
    private int num = 0; // �Ǹ���Ҷ�ӵ�����

    /**
     * <pre>
     * ԭ��
     * Given a binary tree containing digits from 0-9 only, each root-to-leaf path
     * could represent a number.
     * An example is the root-to-leaf path 1->2->3 which represents the number 123.
     * Find the total sum of all root-to-leaf numbers.
     * For example,
     *
     *   1
     *  / \
     * 2   3
     *
     * The root-to-leaf path 1->2 represents the number 12.
     * The root-to-leaf path 1->3 represents the number 13.
     * Return the sum = 12 + 13 = 25.
     * ��Ŀ����
     * ����һ����������ÿ������ֵ��0-9������Ҷ�����һ�����֣������еĸ���Ҷ����ɵ����ֵĺ͡�
     *
     * ����˼·
     * ���û��ݷ���
     * </pre>
     *
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        sum(root);
        return result;
    }

    private void sum(TreeNode root) {
        if (root != null) {
            num = num * 10 + root.val;

            // �Ѿ����˸������
            if (root.left == null && root.right == null) {
                result += num;
            }

            sum(root.left);
            sum(root.right);
            num /= 10;
        }
    }
}
