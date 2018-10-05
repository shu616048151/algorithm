import java.util.Stack;

/**
 * Author: ������
 * Date: 2015-08-21
 * Time: 18:37
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    private Stack<Integer> stack;

    /**
     * <pre>
     * ԭ��
     * Given a binary tree, determine if it is a valid binary search tree (BST).
     * Assume a BST is defined as follows:
     * The left subtree of a node contains only nodes with keys less than the node��s key.
     * The right subtree of a node contains only nodes with keys greater than the node��s key.
     * Both the left and right subtrees must also be binary search trees.
     *
     * ��Ŀ����
     * ��֤����������
     *
     * ����˼·
     * �Զ���������������������������˳�򱣴����������ڶ����������������������
     * һ����С��������е����У�����û������Ԫ�أ��ɴ˿����ж�һ�����Ƿ��Ƕ�����������
     * </pre>
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }

        stack = new Stack<>();
        inOrder(root);

        int i = stack.pop();
        int j;
        while (!stack.isEmpty()) {
            j = stack.pop();
            if (i <= j) {
                return false;
            }

            i = j;
        }

        return true;
    }

    /**
     * �����һ�ö���������ر��������
     *
     * @param root
     */
    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            stack.push(root.val);
            inOrder(root.right);
        }
    }
}
