/**
 * Author: ������
 * Date: 2015-08-21
 * Time: 16:35
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * ԭ��
     * Merge two sorted linked lists and return it as a new list.
     * The new list should be made by splicing together the nodes of the first two lists.
     *
     * ��Ŀ����
     * �ϲ�����������������һ���µ��б��µ�����Ľ����ԭ�ȵ�������������ɣ�
     * Ҳ���ǲ��ܺϲ���������ܰ����´����Ľ�㡣
     *
     * ����˼·
     * ʹ��ͷ���root���и�������������һ��ͷ��㣬��ʹ����������ָ�����������ͷ��㣬
     * ����С�Ľ��ֵ�Ľ��ժ�����ӵ�root�����ĩβ��ͬʱ��ժ����ͷ�����ƶ�����һ����㣬
     * һֱ����������ԭ��������������һ��Ϊ�գ�����ٽ�ʣ�µĽ��ӵ�root�����ĩβ��
     * ��󷵻�root����һ����㣬���Ϊ�µ�����ͷ��
     * </pre>
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0); // ����һ��ͷ��㣬���Ҫɾ����
        ListNode tail = head;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }

            tail = tail.next; // �ƶ����µ�β���
        }

        tail.next = (l1 != null ? l1 : l2);

        return head.next; // head����һ���ڵ��ǵ�һ�����ݽ��
    }
}
