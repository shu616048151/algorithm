/**
 * Author: ������
 * Date: 2015-06-24
 * Time: 08:48
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * A linked list is given such that each node contains an additional random
     * pointer which could point to any node in the list or null.
     *
     * Return a deep copy of the list.
     *
     * ��Ŀ���⣺
     * һ�����������һ��ָ�����������null�Ľ��ָ�룬���������������
     *
     * ����˼·��
     * ��һ�������ƽ�㣬���ƵĽ����ڴ����ƵĽ�����Ȼ���һ��������
     * �ڶ������������ָ��
     * ��������
     * </pre>
     *
     * @param head
     * @return
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        copyNode(head);
        linkRandomPointer(head);

        return splitList(head);
    }

    /**
     * ���ƽ�㣬���ƵĽ����ڴ����ƵĽ�����Ȼ���һ��������
     *
     * @param head ����ͷ
     */
    public void copyNode(RandomListNode head) {
        // ��¼��ǰҪ�����Ƶ���
        RandomListNode node = head;
        while (node != null) {
            // ����һ���µĽ��
            RandomListNode copyNode = new RandomListNode(node.label);
            // ����㴮�ӵ������ƵĽ��󣬲�����Ȼ��ɵ�����
            copyNode.next = node.next;
            node.next = copyNode;
            node = copyNode.next;
        }
    }

    /**
     * �������ָ��
     *
     * @param head ����ͷ
     */
    public void linkRandomPointer(RandomListNode head) {
        // ��¼��ǰҪ�����Ƶ���
        RandomListNode node = head;
        while (node != null) {
            // ���ָ����ָ��ĳ������Ľ��
            if (node.random != null) {
                // ����node�����ƽ������ָ��
                node.next.random = node.random.next;
            }

            // ָ����һ�������ƵĽ��
            node = node.next.next;
        }
    }

    /**
     * �������֣���ԭԭ��������������װ����������
     *
     * @param head ����ͷ
     * @return ������������ͷ
     */
    public RandomListNode splitList(RandomListNode head) {
        // ������ͷ
        RandomListNode copyHead = head.next;
        // ��ǰ����ı����ƵĽ��
        RandomListNode node = head;
        // ��ǰ���ƵĽ��
        RandomListNode copy;

        while (node != null){
            // ָ���ƽ��
            copy = node.next;

            // node.nextָ����һ�������ƵĽ��
            node.next = copy.next;

            // ��һ�������ƵĽ�㲻Ϊnull
            if (node.next != null) {
                // copy.nextָ����һ�����ƵĽ��
                copy.next = node.next.next;
            }

            // nodeָ����һ��Ҫ������ı����ƽ��
            node = node.next;
        }
        return copyHead;
    }
}
