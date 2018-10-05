/**
 * Author: ������
 * Date: 2015-06-18
 * Time: 10:43
 * Declaration: All Rights Reserved !!!
 */
public class Solution {

    /**
     * <pre>
     * Given a binary tree
     *      struct TreeLinkNode {
     *          TreeLinkNode *left;
     *          TreeLinkNode *right;
     *          TreeLinkNode *next;
     *      }
     * Populate each next pointer to point to its next right node. If there is no next right node,
     * the next pointer should be set to NULL.
     *
     * Initially, all next pointers are set to NULL.
     *
     * Note:
     *      - You may only use constant extra space.
     *      - You may assume that it is a perfect binary tree (ie, all leaves are at the same level,
     *        and every parent has two children).
     *
     * For example,
     * Given the following perfect binary tree,
     *      1
     *    /  \
     *   2    3
     *  / \  / \
     * 4  5  6  7
     *
     * After calling your function, the tree should look like:
     *
     *      1 -> NULL
     *    /  \
     *   2 -> 3 -> NULL
     *  / \  / \
     * 4->5->6->7 -> NULL
     *
     * ����˼·��
     * ������ÿһ��ڵ���next������������ÿһ��Ҳ���γ�һ��������
     * ��ÿ�������ͷ�����ǣ��������ӣ����ӣ����ӡ�
     * ����˫ѭ�������ѭ�������Ÿ������ӣ�һֱ���¡�
     * �ڲ�ѭ����������һ��Ľڵ㴮������
     *
     * �������Լ��Һ��ӷŵ����ӵ�next�ϣ����Һ��ӣ����ͨ���Լ���nextָ�룬�ҵ����ھӡ�
     * </pre>
     *
     * @param root
     */
    public void connect(TreeLinkNode root) {

        TreeLinkNode node;
        // ���м��������������һ����ȫ����
        // ��һ��ѭ����������������
        // root.left != null������ã���������һ��û�����������Ľ������
        while (root != null && root.left != null) {
            // ÿ��root��ʾ��һ����ĵ�һ�����
            // node��¼ÿһ����ĵ�һ�����
            node = root;

            // ����ÿ����
            while (node != null) {
                // ��ʾ���ӵ���ͬһ�������µ����ӽ��
                node.left.next = node.right;
                // node����ĳ��������һ�����
                if (node.next != null) {
                    // ������������ӽ�����ӵ��������ͬ�����ڽ������ӽ����
                    node.right.next = node.next.left;
                }

                // �ƶ���ͬ�����һ�����
                node = node.next;
            }

            // �ƶ�����һ��ĵ�һ�����
            root = root.left;
        }

    }
}
