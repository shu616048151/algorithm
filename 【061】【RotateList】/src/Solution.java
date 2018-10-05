/**
 * Author: ������
 * Date: 2015-07-21
 * Time: 18:46
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int n) {

        if (head == null || n < 1) {
            return head;
        }

        ListNode root = new ListNode(0);
        root.next = head;
        ListNode p = root;
        ListNode q = root;

        int count = 0;
        for (int i = 0; i <= n; i++) {
            p = p.next;
            count++;
            if (p == null) {
                count--; // �����г�ͷ�������ݸ���
                n = n % count; // ʵ��Ҫλ�õ�λ��
                // Ϊ���¿�ʼλ����׼��
                i = 0;
                p = head;
            }
        }

        // �ҵ���һ��Ҫ�����Ľ���ǰ��
        // qΪ��һ��Ҫ�����Ľ���ǰ��
        while (p != null) {
            p = p.next;
            q = q.next;

        }

        p = q;
        q = root;
        if (p != null && p.next != null) { // ��Ҫλ�ƵĽ��
            ListNode node;
            while (p.next != null) {
                // ժ�����
                node = p.next;
                p.next = node.next;
                // ���Ͻ��
                node.next = q.next;
                q.next = node;
                q = node; // ���һ���ƶ��Ľڵ�
            }
        }

        return root.next;
    }
}
