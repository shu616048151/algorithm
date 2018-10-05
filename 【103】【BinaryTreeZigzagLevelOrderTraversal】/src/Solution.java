import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: ������
 * Date: 2015-06-23
 * Time: 13:24
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Given a binary tree, return the zigzag level order traversal of its nodes' values.
     * (ie, from left to right, then right to left for the next level and alternate between).
     *
     * For example:
     * Given binary tree {3,9,20,#,#,15,7},
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * return its zigzag level order traversal as:
     * [
     *      [3],
     *      [20,9],
     *      [15,7]
     * ]
     *
     * ��Ŀ���⣺
     * ����һ�ö��������Ӷ����£�����Z���ηֲ������������������Ǵ������ҵģ��²���Ǵ�������
     *
     * ����˼·��
     * �������ֲ�������иĽ���ʹ������ջ������
     * </pre>
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();

        if (root == null) {
            return result;
        }
        // ������־��0��ʾ�����ң�1��ʾ���ҵ���
        int flag = 0;
        TreeNode node;
        // ��¼ÿһ���Ԫ��
        List<Integer> lay = new LinkedList<>();
        // ˫����У�����ջ��ʹ�ã���¼��ǰ���������
        Deque<TreeNode> stack = new LinkedList<>();
        // ��¼��һ���������
        Deque<TreeNode> nextStack = new LinkedList<>();

        stack.add(root);

        while (!stack.isEmpty()) {
            // ɾ��ջ��Ԫ��
            node = stack.removeLast();

            // ������
            lay.add(node.val);

            // �����ǰ�Ǵ����ұ���������������������˳�����
            if (flag == 0) {
                if (node.left != null) {
                    nextStack.addLast(node.left);
                }

                if (node.right != null) {
                    nextStack.addLast(node.right);
                }
            }
            // �����ǰ�Ǵ��ҵ������������������������˳�����
            else {
                if (node.right != null) {
                    nextStack.addLast(node.right);
                }

                if (node.left != null) {
                    nextStack.addLast(node.left);
                }
            }

            // ��ǰ���Ѿ���������
            if (stack.isEmpty()) {
                Deque<TreeNode> temp = nextStack;
                nextStack = stack;
                stack = temp;

                // �����һ�㴦��ķ���
                flag = 1 - flag;
                // ���汾����
                result.add(lay);
                // �����µ���������һ��Ľ��
                lay = new LinkedList<>();
            }
        }

        return result;
    }
}
