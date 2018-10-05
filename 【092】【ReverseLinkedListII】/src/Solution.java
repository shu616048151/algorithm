/**
 * Author: ������
 * Date: 2015-08-21
 * Time: 17:23
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * ԭ��
     * Reverse a linked list from position m to n. Do it in-place and in one-pass.
     * For example:
     * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
     * return 1->4->3->2->5->NULL.
     * Note:
     * Given m, n satisfy the following condition:
     * 1 �� m �� n �� length of list.
     *
     * ��Ŀ����
     * ����һ������������m����n��֮���Ԫ�ؽ���ת��
     * ������n��m���ǺϷ��ģ�ʹ��ԭ�ط������н����ʹ�ó��������ռ䣩
     *
     * ����˼·
     * ���ҵ���һ��Ҫ��ת��Ԫ�ص�ǰ����prev�����ټ���Ҫ���з�ת��Ԫ�ظ�������Ԫ�ؽ���ͷ�巨��
     * ����prev���棬ͬʱ���������Ͽ���
     * </pre>
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode root = new ListNode(0);
        ListNode p = root;
        root.next = head;

        for (int i = 1; i < m && p != null; i++) {
            p = p.next;
        }

        if (p != null) {
            ListNode q = p.next;
            ListNode r;

            // ���mΪ��������Ϊ�Ǵӵ�һ����ʼ����
            if (m < 1) {
                m = 1;
            }

            n = n - m + 1; // nΪҪ���Ľ����Ŀ
            // ���������ʱ��Ҫʹ��β�巨��β��ĸ���Ϊn-1
            for (int i = 1; i < n && q.next != null; i++) {
                // ΪҪ����β��Ľ��
                r = q.next;

                // ��q���ĺ������β�����
                q.next = r.next;
                r.next = p.next;
                p.next = r;
            }

            head = root.next;
        }

        return head;
    }
}
