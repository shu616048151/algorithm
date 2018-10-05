import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: ������
 * Date: 2015-06-20
 * Time: 12:18
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Given a binary tree, imagine yourself standing on the right side of it,
     * return the values of the nodes you can see ordered from top to bottom.
     *
     * For example:
     * Given the following binary tree,
     *      1            <---
     *    /   \
     *   2     3         <---
     *    \     \
     *     5     4       <---
     * You should return [1, 3, 4].
     *
     *  ��Ŀ���⣺
     *  ����һ���������������Լ�վ�������ұߣ����ش��µ������ܿ����Ľڵ��ֵ��
     *
     * ����˼·��
     * �������Ĳ�α�����ÿ�㰴�մ������ҵ�˳�����η��ʽڵ㣬��ÿһ��ȡ���ұߵĽ�㣩
     * </pre>
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();

        if (root != null) {
            Deque<TreeNode> deque = new LinkedList<>();
            // ��ǰ��Ľ����
            int current = 1;
            // ��һ��Ľ����
            int next = 0;
            TreeNode node;
            deque.addLast(root);
            while (deque.size() > 0) {
                // ȡ��һ�����
                node = deque.removeFirst();
                current--;

                // ��ӷǿյ�����
                if (node.left != null) {
                    next++;
                    deque.addLast(node.left);
                }

                // ��ӷǿյ��ҽ��
                if (node.right != null) {
                    next++;
                    deque.addLast(node.right);
                }

                // �����ǰ���Ѿ���������
                if (current == 0) {
                    // ����˲������һ�����ֵ
                    result.add(node.val);
                    // ������һ���Ԫ�ظ���
                    current = next;
                    next = 0;
                }
            }
        }

        return result;
    }
}
