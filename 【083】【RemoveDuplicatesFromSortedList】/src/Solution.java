/**
 * Author: ������
 * Date: 2015-08-21
 * Time: 19:45
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * ԭ��
     * Given a sorted linked list, delete all duplicates such that each element appear only once.
     * For example,
     * Given 1->1->2, return 1->2.
     * Given 1->1->2->3->3, return 1->2->3.
     *
     * ��Ŀ����
     * ����һ��������ɾ���ظ���Ԫ�أ���ͬ��ֻ����һ����
     *
     * ����˼·
     * ʹ��һ��ָ��ָ�������ͷ�������һ���뵱ǰ�Ľ�������ɾ����ֱ������һ������ͬ�ģ���ָ��ָ����
     * ���µĽ�㣬�ظ�������ֱ�����еĽ�㶼�����ꡣ
     * </pre>
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode point;
        ListNode tail = head; // ָ���½���β������ʼʱ����ֻ��һ��Ԫ�أ�������ͷ

        if (head != null) {
            point = head.next; // ָ����һ������ͷ��
            while (point != null) { // ��һ������δ��ĩβ

                if (tail.val != point.val) { // �����β�ڵ㲻��ͬ���ͽ�����ͬ�Ľڵ����ӵ�tail����һ��λ��
                    tail.next = point;
                    tail = tail.next; // ����ָ����β
                }

                point = point.next;
            }

            tail.next = null; // ��βָ���
        }

        return head;
    }
}
