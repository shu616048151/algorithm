/**
 * Author: ������
 * Date: 2015-08-21
 * Time: 16:04
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * ԭ��
     * You are given two linked lists representing two non-negative numbers.
     * The digits are stored in reverse order and each of their nodes contain
     * a single digit. Add the two numbers and return it as a linked list.
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     *
     * ��Ŀ����
     * ���������������������Ǹ�����ÿһ���ڵ����һ����λ�������Ƿ���洢�ģ�
     * ����һ������ʾ���λ�����һ������ʾ���λ��������������Ӻͣ�������������ʽ���ء�
     *
     * ����˼·
     * �����������ӵ�һ����ʼ����������ӣ�����ٳ���10���̣���Ϊ��һλ��ӵĽ�λ��
     * ͬʱ��¼��������Ϊ��λ�Ľ����һֱ����ֱ�����еĽ�㶼�����ꡣ
     * </pre>
     *
     * @param l1 ��һ����
     * @param l2 �ڶ�����
     * @return ���
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode root = new ListNode(0); // ͷ���
        ListNode r = root;
        root.next = l1;

        int carry = 0; // ��ʼ��λ
        int sum;
        while (p1 != null && p2 != null) {
            sum = p1.val + p2.val + carry;
            p1.val = sum % 10; // ��λ�Ľ��
            carry = sum / 10; // ���ν�λ

            r.next = p1;
            r = p1; // ָ�����һ����ӵĽ��
            p1 = p1.next;
            p2 = p2.next;

        }

        if (p1 == null) {
            r.next = p2;
        } else {
            r.next = p1;
        }

        // ���һ����ӻ��н�λ
        if (carry == 1) {
            // ��ʼʱr.next�ǵ�һ��Ҫ��ӵĽ��
            while (r.next != null) {
                sum = r.next.val + carry;
                r.next.val = sum % 10;
                carry = sum / 10;
                r = r.next;
            }

            // �������˻��н�λ����Ҫ����һ���µĽ��
            if (carry == 1) {
                r.next = new ListNode(1);
            }
        }

        return root.next;
    }
}
