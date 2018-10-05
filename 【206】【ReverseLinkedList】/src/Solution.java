/**
 * Author: ������
 * Date: 2015-06-19
 * Time: 11:17
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * Reverse a singly linked list.
     * ��ת������
     * ʹ��ͷ�巨
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        // ͷ���
        ListNode root = new ListNode(0);
        ListNode nextNode;
        while (head != null) {
            nextNode = head.next;
            head.next = root.next;
            root.next = head;
            head = nextNode;
        }

        return root.next;
    }

    /**
     * TODO ʹ�õݹ�ⷨ
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null) {
            return null;
        }

        reverseList2(head.next).next = head;

        return null;
    }
}
