
/**
 * Author: ������
 * Date: 2015-06-23
 * Time: 10:05
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Given inorder and postorder traversal of a tree, construct the binary tree.
     *
     * Note:
     * You may assume that duplicates do not exist in the tree.
     *
     * ��Ŀ���⣺
     * ����һ����������ͺ���������У�����һ�ö�����
     * ע�⣺
     * ����û���ظ�Ԫ��
     *
     * ����˼·��
     * ������������һ��Ԫ�ؾ������ĸ����(ֵΪr)��
     * �������������������ֵΪr��λ��idx��idx������������з�Ϊ��������������
     * ��Ӧ���Խ�������������з��������������ݹ����������
     * </pre>
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        // ��������
        if (inorder == null || postorder == null || inorder.length == 0
                || inorder.length != postorder.length) {
            return null;
        }

        // ����������
        return solve(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    /**
     * ����������
     *
     * @param inorder   ��������Ľ��
     * @param x         ��������Ŀ�ʼλ��
     * @param y         ��������Ľ���λ��
     * @param postorder ��������Ľ��
     * @param i         ��������Ŀ�ʼλ��
     * @param j         ��������Ľ���λ��
     * @return ������
     */
    public TreeNode solve(int[] inorder, int x, int y, int[] postorder, int i, int j) {

        if (x >= 0 && x <= y && i >= 0 && i <= j) {
            // ֻ��һ��Ԫ�أ�����ʱҲ��i=j�ɣ�
            if (x == y) {
                return new TreeNode(postorder[j]);
            }
            // ����һ��Ԫ�أ���ʱҲ��i<j
            else if (x < y) {
                // ���������
                TreeNode root = new TreeNode(postorder[j]);

                // �Ҹ����������������±�
                int idx = x;
                while (idx < y && inorder[idx] != postorder[j]) {
                    idx++;
                }

                // �������ǿգ�����������
                int leftLength = idx - x;
                if (leftLength > 0) {
                    // i, i + leftLength - 1��ǰ�����������������ʼ������λ��
                    root.left = solve(inorder, x, idx - 1, postorder, i, i + leftLength - 1);
                }

                // �������ǿգ�����������
                int rightLength = y - idx;
                if (rightLength > 0) {
                    // i + leftLength, j - 1��ǰ�����������������ʼ������λ��
                    root.right = solve(inorder, idx + 1, y, postorder, i + leftLength, j - 1);
                }

                return root;
            }
        }

        return null;
    }
}
