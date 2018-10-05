import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Author: ������
 * Date: 2015-06-30
 * Time: 19:21
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Merge k sorted linked lists and return it as one sorted list.
     * Analyze and describe its complexity.
     *
     * ��Ŀ���⣺
     * �ϲ�k���źõĵĵ�����
     *
     * ����˼·��
     * ʹ��һ��С�������в������Ƚ�k��������ĵ�һ�������ѣ���ȡ���е���С�أ���Ϊ��С��Ԫ�أ�
     * �����Ԫ�ص���һ�����ѣ���ȡ������С�ģ����β���ֱ����Ϊ��
     * </pre>
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {

        // Ϊ�ջ���û��Ԫ��
        if (lists == null || lists.length < 1) {
            return null;
        }

        // ֻ��һ��Ԫ��
        if (lists.length == 1) {
            return lists[0];
        }

        // ����һ��С���ѣ�����ʹ��һ�������ڲ�����Ϊ�Ƚ���
        MinHeap<ListNode> minHeap = new MinHeap<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1 == null) {
                    return -1;
                }

                if (o2 == null) {
                    return 1;
                }

                return o1.val - o2.val;
            }
        });


        // ������������ĵ�һ��������
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.add(node);
            }
        }

        // ͷ��㣬������ʹ��
        ListNode head = new ListNode(0);
        // ��ǰ����Ľ��
        ListNode curr = head;

        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.deleteTop();

            // ������һ����㲻Ϊ�վͽ���һ��������
            if (node.next != null) {
                minHeap.add(node.next);
            }

            curr.next = node;
            curr = node;
        }

        return head.next;
    }

    /**
     * С����
     *
     * @param <T>
     */
    private static class MinHeap<T> {
        // ����Ԫ�ش�ŵļ���
        private List<T> items;

        private Comparator<T> comp;

        /**
         * ����һ��׵��ʼ��С��32
         */
        public MinHeap(Comparator<T> comp) {
            this(32, comp);
        }

        /**
         * ����һ��ָ����ʼ��С�Ķ�
         *
         * @param size ��ʼ��С
         */
        public MinHeap(int size, Comparator<T> comp) {
            items = new ArrayList<>(size);
            this.comp = comp;
        }

        /**
         * ���ϵ�����
         *
         * @param index ������Ԫ�ص���ʼλ��
         */
        public void siftUp(int index) {
            T intent = items.get(index); // ��ȡ��ʼ������Ԫ�ض���

            while (index > 0) { // ������Ǹ�Ԫ��
                int parentIndex = (index - 1) / 2; // �Ҹ�Ԫ�ض����λ��
                T parent = items.get(parentIndex);  // ��ȡ��Ԫ�ض���
                if (comp.compare(intent, parent) < 0) { //���Ƶ��������ӽڵ�ȸ��ڵ�С
                    items.set(index, parent); // �����ڵ����·�
                    index = parentIndex; // ��¼���ڵ��·ŵ�λ��
                } else { // �ӽڵ㲻�ȸ��ڵ�С��˵������·���Ѿ�����С�����ź�˳���ˣ�����Ҫ������
                    break;
                }
            }

            // index��ʱ��¼�ǵ����һ�����·ŵĸ��ڵ��λ�ã�Ҳ������������
            // ���Խ��ʼ�ĵ�����Ԫ��ֵ����indexλ�ü���
            items.set(index, intent);
        }

        /**
         * ���µ�����
         *
         * @param index �����Ƶ�Ԫ�ص���ʼλ��
         */
        public void siftDown(int index) {
            T intent = items.get(index);  // ��ȡ��ʼ������Ԫ�ض���
            int leftIndex = 2 * index + 1; // // ��ȡ��ʼ������Ԫ�ض�������ӽ���Ԫ��λ��

            while (leftIndex < items.size()) { // ��������ӽ��
                T minChild = items.get(leftIndex); // ȡ���ӽ���Ԫ�ض��󣬲��Ҽٶ���Ϊ�����ӽ������С��
                int minIndex = leftIndex; // �����ӽڵ�����С�ڵ�Ԫ�ص�λ�ã��ٶ���ʼʱΪ���ӽ���λ��

                int rightIndex = leftIndex + 1;  // ��ȡ���ӽ���λ��
                if (rightIndex < items.size()) {  // ��������ӽ��
                    T rightChild = items.get(rightIndex);  // ��ȡ���ӽ���Ԫ�ض���
                    if (comp.compare(rightChild, minChild) < 0) {  // �ҳ������ӽڵ��е���С�ӽ��
                        minChild = rightChild;
                        minIndex = rightIndex;
                    }
                }

                // �����С�ӽڵ�ȸ��ڵ�С������Ҫ���µ���
                if (comp.compare(minChild, intent) < 0) {
                    items.set(index, minChild); // ���ӽڵ�������
                    index = minIndex; // ��¼���ƽڵ��λ��
                    leftIndex = index * 2 + 1; // �ҵ����ƽڵ�����ӽڵ��λ��
                } else { // ��С�ӽڵ㲻�ȸ��ڵ�С��˵������·���Ѿ�����С�����ź�˳���ˣ�����Ҫ������
                    break;
                }
            }

            // index��ʱ��¼�ǵ����һ�������Ƶ��ӽڵ��λ�ã�Ҳ������������
            // ���Խ��ʼ�ĵ�����Ԫ��ֵ����indexλ�ü���
            items.set(index, intent);
        }

        /**
         * ��������һ��Ԫ��
         *
         * @param item �ȴ���ӵ�Ԫ��
         */
        public void add(T item) {
            items.add(item); // ��Ԫ����ӵ����
            siftUp(items.size() - 1); // ѭ�����ƣ�������ع�
        }

        /**
         * ɾ���Ѷ�Ԫ��
         *
         * @return �Ѷ�����Ԫ��
         */
        public T deleteTop() {
            if (items.isEmpty()) { // ������Ѿ�Ϊ�գ��ͱ����쳣
                throw new RuntimeException("The heap is empty.");
            }

            T maxItem = items.get(0); // ��ȡ�Ѷ�Ԫ��
            T lastItem = items.remove(items.size() - 1); // ɾ�����һ��Ԫ��
            if (items.isEmpty()) { // ɾ��Ԫ�غ������Ϊ�յ������˵��ɾ����Ԫ��Ҳ�ǶѶ�Ԫ��
                return lastItem;
            }

            items.set(0, lastItem); // ��ɾ����Ԫ�ط���Ѷ�
            siftDown(0); // �������µ�����
            return maxItem; // ���ضѶ�Ԫ��
        }

        /**
         * �ж϶��Ƿ�Ϊ��
         *
         * @return true�ǿգ�false��
         */
        public boolean isEmpty() {
            return items.isEmpty();
        }
    }

}
