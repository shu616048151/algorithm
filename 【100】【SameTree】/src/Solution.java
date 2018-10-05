/**
 * Author: ������
 * Date: 2015-08-21
 * Time: 18:40
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * ԭ��
     * Given two binary trees, write a function to check if they are equal or not.
     * Two binary trees are considered equal if they are structurally identical and
     * the nodes have the same value.
     *
     * ��Ŀ����
     * �����������������ж����������Ƿ���ȡ�
     * �����������Ľṹ��ͬ�����ֵ�����ʱ������ȡ�
     *
     * ����˼·
     * ʹ�õݹ������⣬���жϵ�ǰ���ֵ�Ƿ���ȣ������Ⱦ��ٱȽ�������������
     * ֻ�е����еĽ�㶼��Ȳ���ȡ�
     * </pre>
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }

        if (p != null && q == null) {
            return false;
        }

        if (p == null && q != null) {
            return false;
        }


        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
