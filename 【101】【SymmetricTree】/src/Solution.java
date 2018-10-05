/**
 * Author: ������
 * Date: 2015-08-21
 * Time: 18:42
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * ԭ��
     * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
     * For example, this binary tree is symmetric:
     *
     *     1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     *
     * ����But the following is not:
     *
     *   1
     *  / \
     * 2   2
     * \   \
     * 3    3
     *
     * Note:
     * Bonus points if you could solve it both recursively and iteratively.
     * ��Ŀ����
     * ����һ�������ж����Ƿ��ǶԳƵġ��������������Ƿ������������ľ���
     *
     * ����˼·
     * ʹ�õݹ������⣬���ж������ӽ���Ƿ���ȣ����Ⱦͷ���false����Ⱦͽ����ӽ�����������
     * ���ӽ�������ӽ����бȽϲ�����ͬʱ�����ӽ��������������ӽ������������бȽϣ�ֻ����
     * ��ͬʱΪ���ǲŷ���true�����򷵻�false��
     * </pre>
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        } else {
            return isSame(root.left, root.right);
        }
    }

    private boolean isSame(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right == null || left == null && right != null) {
            return false;
        } else {
            return left.val == right.val && isSame(left.left, right.right)
                    && isSame(left.right, right.left);
        }
    }
}
