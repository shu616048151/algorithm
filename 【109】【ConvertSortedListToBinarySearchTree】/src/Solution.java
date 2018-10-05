/**
 * Author: ������
 * Date: 2015-06-23
 * Time: 07:16
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Given a singly linked list where elements are sorted in ascending order,
     * convert it to a height balanced BST.
     *
     * ��Ŀ���⣺
     * ����һ������ĵ���������ת����һ�Ÿ߶�ƽ��Ķ�����
     *
     * ����˼·��
     * �ⷨһ�����������е�ֵ����һ�������У�ͨ���������������������㷨ʱ�临�Ӷ��ǣ�O(n)���ռ临�Ӷ��ǣ�O(n)
     * �ⷨ�������õݹ�ķ�ʽ��
     *      ��һ�����м��㣬��������㣬
     *      �������м�����벿�ֹ�����������
     *      �������м�����Ҳ��ֹ���������
     * ����õڶ��ֽⷨ
     * </pre>
     *
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        // �������Ϊ�վ�ֱ�ӷ���null
        if (head == null) {
            return null;
        }

        // ����ֻ��һ�����
        if (head.next == null) {
            return new TreeNode(head.val);
        }

        // �����ƶ���㣬ÿ���ƶ�����λ��
        ListNode fast = head.next.next;
        // ��¼�м���
        ListNode mid = head;
        // ���м���
        while (fast != null && fast.next != null) {
            mid = mid.next;
            fast = fast.next.next;
        }

        // ���м������һ�������Ϊ�����
        TreeNode root = new TreeNode(mid.next.val);
        // ����������
        root.right = sortedListToBST(mid.next.next);
        // ��¼����Ҫ�Ͽ��ĵ�
        ListNode midNext = mid.next;
        // �Ͽ����������ƻ�ԭ��������Ľṹ��
        mid.next = null;
        // ����������
        root.left = sortedListToBST(head);
        // ���½�����Ӻ�
        mid.next = midNext;
        // ���ؽ��
        return root;
    }
}
