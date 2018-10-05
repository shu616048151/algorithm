/**
 * Author: ������
 * Date: 2015-08-21
 * Time: 19:43
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * ԭ��
     * Given a sorted linked list, delete all nodes that have duplicate numbers,
     * leaving only distinct numbers from the original list.
     * For example,
     * Given 1->2->3->3->4->4->5, return 1->2->5.
     * Given 1->1->1->2->3, return 2->3.
     *
     * ��Ŀ����
     * ����һ���ź���ĵ�����ɾ�������ظ���Ԫ�ء�ֻ����ֻ��һ��ֵ��Ԫ�ء�
     *
     * ����˼·
     * ���������һ���������root��root�ӵ�ԭ����ͷ�����������ͷ���͸�����ָ�룬�����ص�Ԫ�ؽ���ɾ����
     * </pre>
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {

        ListNode root = new ListNode(0); // ͷ���
        root.next = head;
        ListNode p = head;
        ListNode q = root; // ��¼���һ��û���ظ���Ԫ�أ���ʼָ��ͷ���

        int delta = 0; // Ԫ���ظ�����

        while (p != null && p.next != null) {
            if (p.val == p.next.val) { // ���������������ͬ
                delta++;
                p = p.next; // �ƶ�����һ�����
            } else { // �������������㲻��ͬ
                if (delta == 0) { // ֵΪp.val�Ľ��û���ظ�
                    q.next = p; // ���ӵ�û�и���Ԫ��
                    q = p; // ָ�����һ��δ�ظ���Ԫ��
                    p = p.next; // �ƶ�����һ�����
                } else { // ֵΪp.val�Ľ�����ظ�
                    p = p.next; // �ƶ�����һ��Ԫ��
                    q.next = p.next; // ȥ���ظ���Ԫ��
                    delta = 0; // Ԫ���ظ���������Ϊ0
                }
            }
        }

        if (delta != 0) { // ������һ��Ԫ���Ǹ��ľ�ȥ��
            q.next = null;
        } else { // ���û���ظ��Ϳ����ӵ���β
            q.next = p;
        }

        return root.next;
    }
}
