/**
 * Author: ������
 * Date: 2015-08-21
 * Time: 16:37
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * ԭ��
     * Given a linked list, swap every two adjacent nodes and return its head.
     * For example,
     * Given 1->2->3->4, you should return the list as 2->1->4->3.
     * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
     *
     * ��Ŀ����
     * ����һ���������ɶԽ����������ڵĽ�㡣�㷨��Ӧ�������������ռ䣬���ܸĽ���ֵ��ֻ�ܽ�����㡣
     *
     * ����˼·
     * ʹ��һ��ͷ���root��������������Ҫ���н���������ÿ������λ�ý��н�����
     * ���Ұѽ�����Ľ��ӵ�root�������ϣ�ֱ�����еĽ�㶼�����ꡣ
     * </pre>
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode node = new ListNode(0); // ͷ���
        node.next = head;

        // pָ���µ������β���
        ListNode p = node;
        ListNode tmp;

        // ÿ�������в���
        while (p.next != null && p.next.next != null) {
            // ��¼��һ��Ҫ���д����λ��
            tmp = p.next.next;
            // �����������������㽻��
            p.next.next = tmp.next;
            tmp.next = p.next;
            p.next = tmp;
            // ָ�򷵻�������µ�β���
            p = tmp.next;
        }

        head = node.next;
        node.next = null;

        return head;
    }
}
