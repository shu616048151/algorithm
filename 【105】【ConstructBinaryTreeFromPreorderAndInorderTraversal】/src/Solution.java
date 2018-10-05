/**
 * Author: ������
 * Date: 2015-06-23
 * Time: 14:04
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Given preorder and inorder traversal of a tree, construct the binary tree.
     *
     * Note:
     * You may assume that duplicates do not exist in the tree.
     *
     * ��Ŀ���⣺
     * ����һ��ǰ�������������У�����һ��������
     * ע�⣺
     *   - ��������Ԫ���ظ�Ԫ��
     *
     * ����˼·��
     * ǰ�������һ��Ԫ���Ǹ���㣨k���������������������ֵΪk���±�idx
     * idx������������зֳ�������������ǰ���������Ҳһ�����ɽ��еݹ����
     * </pre>
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // ����У��
        if (preorder == null || inorder == null || preorder.length == 0
                || preorder.length != inorder.length) {
            return null;
        }
        return solve(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
     * �����������������������ȷ�������������Լ���֤
     *
     * @param preorder ��������Ľ��
     * @param x        ��������Ŀ�ʼλ��
     * @param y        ��������Ľ���λ��
     * @param inorder  ��������Ľ��
     * @param i        ��������Ŀ�ʼλ��
     * @param j        ��������Ľ���λ��
     * @return �������ĸ����
     */
    public TreeNode solve(int[] preorder, int x, int y, int[] inorder, int i, int j) {

        if (x >= 0 && x <= y && i >= 0 && i <= j) {
            // ֻ��һ��Ԫ��
            if (x == y) {
                return new TreeNode(preorder[x]);
            } else if (x < y) {
                // ��¼����������
                int idx = i;
                while (idx <= j && inorder[idx] != preorder[x]) {
                    idx++;
                }

                // ���������
                TreeNode root = new TreeNode(inorder[idx]);

                // �������Ľ�����
                int leftLength = idx - i;
                //
                if (leftLength > 0) {
                    // x + 1, x + leftLength����������ʼ�ͽ���λ��
                    root.left = solve(preorder, x + 1, x + leftLength, inorder, i, idx - 1);
                }

                // �������Ľ�����
                int rightLength = j - idx;
                if (rightLength > 0) {
                    // x + leftLength + 1, y����������ʼ�ͽ���λ��
                    root.right = solve(preorder, x + leftLength + 1, y, inorder, idx + 1, j);
                }
                return root;
            }
        }

        return null;
    }
}
