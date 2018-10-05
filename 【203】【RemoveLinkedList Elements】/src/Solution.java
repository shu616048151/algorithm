/**
 * Author: ������
 * Date: 2015-06-19
 * Time: 13:57
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * Remove all elements from a linked list of integers that have value val.
     * <p>
     * Example
     * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
     * Return: 1 --> 2 --> 3 --> 4 --> 5
     * <p>
     * ����һֵval���ڵ�������ɾ��ֵΪval�Ľ��
     * <p>
     * ����˼·
     * ������ͷ���һ����㣬�������������ɾ������
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode root = new ListNode(1);
        root.next = head;
        // ���ڼ�¼Ҫ�����Ԫ�ص�ǰ�����
        ListNode prev = root;

        // prev.next��ʾҪ����Ľ��
        while (prev.next != null) {
            // Ҫ����Ľ����Ҫɾ���Ľ��
            if (prev.next.val == val) {
                // �Խ�����ɾ������
                prev.next = prev.next.next;
            }
            // ��ǰ����Ľڵ㲻��Ҫɾ����prev�ƶ�����һ�����
            else {
                prev = prev.next;
            }
        }

        // �����µĸ����
        return root.next;
    }
}
