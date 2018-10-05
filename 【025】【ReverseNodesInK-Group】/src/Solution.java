/**
 * Author: ������
 * Date: 2015-06-30
 * Time: 21:20
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Given a linked list, reverse the nodes of a linked list k at a time
     * and return its modified list.
     *
     * If the number of nodes is not a multiple of k then left-out nodes
     * in the end should remain as it is.
     *
     * You may not alter the values in the nodes, only nodes itself may
     * be changed.
     *
     * Only constant memory is allowed.
     *
     * For example,
     * Given this linked list: 1->2->3->4->5
     * For k = 2, you should return: 2->1->4->3->5
     * For k = 3, you should return: 3->2->1->4->5
     *
     * ��Ŀ���⣺
     * ����һ����������һ��������K��ÿK�������з�ת��������Ľ��������K����
     * ����ԭ��������˳�򲻱䡣
     *
     * ����˼·��
     *
     * ��һ��ָ���¼���Ӻõ���������һ����㣨tail����
     * ��һ��ָ���¼��һ�����ӺõĲ��ֵ����һ����㣨head��
     * ��δ����Ľ����head������β�巨����k��Ԫ�أ��ٽ�head�ƶ���tail����
     * tail���¼�¼�����β��㣬ֱ�����е�Ԫ�ض������˲�����
     * �������һ��Ԫ�ز���k������Ϊ���й�β�巨�����Ի�Ҫ���л�ԭ��
     * ������headԪ�ؽ���β�巨�Ϳ�����
     *
     * </pre>
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {

        if (k <= 1) {
            return head;
        }

        ListNode root = new ListNode(0);
        // �����ͷһ��Ԫ�ص�ǰ��
        ListNode groupHead = root;
        // ��ǰҪ����Ľ��
        ListNode curr = head;
        // ����õ������β���
        ListNode groupTail = head;
        // ��ǰҪ����Ľ��ĺ��
        ListNode next;

        // ��ÿ���飬�����˶��ٸ����
        int count = 0;


        while (curr != null) {

            // ����Ƿ���ĵ�һ��Ԫ�ؾͼ�¼��
            if (count == 0) {
                groupTail = curr;
            }

            // ��¼�����Ԫ�ظ���
            count++;
            // ��¼��һ����������
            next = curr.next;
            // ����β�巨����
            curr.next = groupHead.next;
            groupHead.next = curr;
            curr = next;

            // �Ѿ���������k����㣬����ͷ��ǰ���ƶ������һ�����ӺõĽ��
            if (count == k) {
                groupHead = groupTail;
                // ����������
                count = 0;
            }
        }


        // ˵������������k������������������������ĸ�Ԫ�صĽ�㣬
        // �ٴ�ʹ��β�巨���л�ԭ
        if (count != 0) {
            curr = groupHead.next;
            groupHead.next = null;

            while (curr != null) {
                next = curr.next;
                curr.next = groupHead.next;
                groupHead.next = curr;
                curr = next;
            }
        }

        return root.next;
    }
}
