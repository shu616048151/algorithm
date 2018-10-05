import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: ������
 * Date: 2015-06-22
 * Time: 14:54
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Given a binary tree, return the postorder traversal of its nodes' values.
     *
     * For example:
     * Given binary tree {1,#,2,3},
     *      1
     *       \
     *        2
     *       /
     *      3
     * return [3,2,1].
     *
     * Note: Recursive solution is trivial, could you do it iteratively?
     *
     * ��Ŀ���⣺
     * ����һ�Ŷ�������������ĺ�������Ľ��ֵ
     *
     * ע�⣺
     *   - �ݹ�ⷨ�����ף��볢�������ʽ
     *
     * ����˼·��
     * �ǵݹ�
     * ���ݺ��������˳���ȷ������������ٷ���������������ʸ��ڵ㣬������ÿ��������˵��
     * �ְ���ͬ���ķ���˳����б�������������ķǵݹ��ʵ�������˵Ҫ��һЩ��Ҫ��֤����
     * �����������������������ʺ���ܷ��ʣ�˼·���£�
     *
     * ������һ�ڵ�P��
     * 1���Ƚ��ڵ�P��ջ��
     * 2����P���������Ӻ��Һ��ӣ�����P�������ӻ��Һ��ӣ������Һ����Ѿ�����������
     *      ��ֱ������ڵ�P���������ջ������ջ�ڵ�P���Ϊ��һ������Ľڵ㣬�ٽ���ʱ��
     *      ջ�������Ϊ��ǰ�ڵ㣻
     * 3����������2���е���������P���Һ��Ӻ�����������ջ����ǰ�ڵ�������Ϊջ����㣬
     *      ֮���ظ�����2����
     * 4��ֱ��ջ�գ�����������
     * </pre>
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();

        if (root != null) {
            // ˫�˶��У�����ջ��ʹ��
            Deque<TreeNode> deque = new LinkedList<>();
            // ָ��ǰһ������Ľ��
            TreeNode prev = null;
            // ָ��ǰ����Ľ��
            TreeNode curr;
            // �������ջ
            deque.addLast(root);
            // ջ�ǿ�
            while (!deque.isEmpty()) {
                // ��ȡջ��Ԫ�أ���ɾ����
                curr = deque.getLast();
                if ((curr.left == null && curr.right == null) // ��ǰԪ������������
                        // prev == null && curr.left == prev����ǰ���ֻ���������������������Ѿ�������
                        // prev == null && curr.right == prev����ǰ����������������������������Ѿ�������
                        || (prev != null && (curr.left == prev || curr.right == prev))) {
                    // ɾ��ջ��Ԫ��
                    curr = deque.removeLast();
                    // ���ֵ��ջ
                    list.add(curr.val);
                    // ������һ������Ľ��
                    prev = curr;
                } else {

                    // ��������δ�����꣬���ǿ�����������ջ

                    if (curr.right != null) {
                        deque.addLast(curr.right);
                    }

                    if (curr.left != null) {
                        deque.addLast(curr.left);
                    }
                }
            }
        }

        return list;
    }
}
