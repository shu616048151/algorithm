/**
 * Author: ������
 * Date: 2015-08-21
 * Time: 19:23
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * ԭ��
     * Sort a linked list using insertion sort.
     *
     * ��Ŀ����
     * ��һ�����������в�������
     *
     * ����˼·
     * ʹ��һ��ָ��pָ��δ�ź��������ĵ�һ����㣬������õĲ������ҵ��ҵ�һ�����ڵ���q��ǰ����㣬
     * ��p��Ӧ�Ľ����뵽��ȷλ�ã�p����ָ��δ�ź��������ĵ�һ����㡣ֱ�������������á�
     * </pre>
     *
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {

        ListNode root = new ListNode(0); // ͷ���
        root.next = head;
        ListNode p = head;
        ListNode q;
        ListNode r;

        while (p != null && p.next != null) {
            if (p.val <= p.next.val) {
                p = p.next;
            } else {
                q = p.next;
                p.next = q.next;

                r = root;
                // �ҵ�һ�����ڵ���q.val��ǰ����㣬��Ϊ��root.next��p֮��ض����������Ľ��
                while (r.next.val <= q.val) {
                    r = r.next;
                }

                q.next = r.next;
                r.next = q;
            }
        }

        return root.next;
    }
}
