import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: ������
 * Date: 2015-06-22
 * Time: 19:27
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Follow up for problem "Populating Next Right Pointers in Each Node".
     *
     * What if the given tree could be any binary tree? Would your previous solution still work?
     * Note:
     *
     * You may only use constant extra space.
     * For example,
     * Given the following binary tree,
     *      1
     *    /  \
     *   2    3
     *  / \    \
     * 4   5    7
     * After calling your function, the tree should look like:
     *      1 -> NULL
     *    /  \
     *   2 -> 3 -> NULL
     *  / \    \
     * 4-> 5 -> 7 -> NULL
     *
     * ��Ŀ���⣺
     * ����һ�ö�������ÿ�����ڵ���������һ��nextָ�룬ָ������ͬһ������ڵ��ұߵĽڵ㡣��ͬ��Ľ�㶼������
     *
     * ����˼·��
     * �������в�α�������ÿһ�㴮������
     * </pre>
     *
     * @param root
     */
    public void connect(TreeLinkNode root) {
        if (root != null) {
            // ������
            List<TreeLinkNode> list = new LinkedList<>();
            // ��ǰ����Ľ���ǰһ�����
            TreeLinkNode prev = null;
            // ��ǰ����Ľ��
            TreeLinkNode node;
            // ��ǰ��ʣ��Ľ�����
            int curr = 1;
            // ��¼��һ���Ԫ�ظ���
            int next = 0;

            // ��������
            list.add(root);

            // ���зǿ�
            while (list.size() > 0) {
                // ɾ������Ԫ��
                node = list.remove(0);
                // ��ǰ��ʣ��������
                curr--;

                // �������ǿգ����ӽ�����
                if (node.left != null) {
                    list.add(node.left);
                    next++;
                }

                // �������ǿգ����ӽ�����
                if (node.right != null) {
                    list.add(node.right);
                    next++;
                }

                // �����ǰ�㴦������
                if (curr == 0) {

                    // ����һ���Ԫ�ؽ��д���
                    Iterator<TreeLinkNode> iterable = list.iterator();
                    if (iterable.hasNext()) {
                        prev = iterable.next();
                        while (iterable.hasNext()) {
                            node = iterable.next();
                            prev.next = node;
                            prev = node;
                        }
                    }

                    // ���µ�ǰ��ʣ��Ľ����
                    curr = next;
                    // ����ͳ���²�����
                    next = 0;
                }
            }
        }
    }
}
