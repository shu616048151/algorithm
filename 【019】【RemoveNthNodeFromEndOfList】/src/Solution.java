/**
 * Author: ������
 * Date: 2015-08-21
 * Time: 16:30
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * ԭ��
     * Given a linked list, remove the nth node from the end of list and return its head.
     * For example,
     *
     * Given linked list: 1->2->3->4->5, and n = 2.
     * After removing the second node from the end, the linked list becomes 1->2->3->5.
     *
     * Note:
     * Given n will always be valid.
     * Try to do this in one pass.
     *
     * ��Ŀ����
     * ɾ��������ĵ����ڣθ���㣬ע�⣺����ģζ��ǺϷ�����һ�α�������ɲ�����
     *
     * ����˼·
     * ����һ��ָ�����ҵ���N���ڵ㣬Ȼ������һ��ָ��ָ��ͷ��㣬Ȼ������ָ��һ���ߣ�
     * ֱ��ǰһ��ָ��ֱ����ĩβ����һ��ָ����ǵ�����N+1����㣬ɾ��������N�����Ϳ����ˡ�
     * </pre>
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pa = head;
        ListNode pb = head;

        // �ҵ���n�����
        for (int i = 0; i < n && pa != null; i++) {
            pa = pa.next;
        }


        if (pa == null) {
            head = head.next;
            return head;
        }

        // pb��pa���n-1�����
        // ��pa.nextΪnull��pb�ڵ�����n+1��λ��
        while (pa.next != null) {
            pa = pa.next;
            pb = pb.next;
        }

        pb.next = pb.next.next;
        return head;
    }
}
