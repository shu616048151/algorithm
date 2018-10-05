/**
 * Author: ������
 * Date: 2015-08-21
 * Time: 19:25
 * Declaration: All Rights Reserved !!!
 */
public class MinStack {
    private final static int DEFAULT_SIZE = 1000;
    private int[] stack;
    private int[] minIndex; // ���ڱ���ǰn�����ݵ�ջ����СԪ�ص��±�
    private int min = Integer.MAX_VALUE; // ���ڼ�¼��������е���С����
    private int index = -1; // ��¼��СԪ����stack�е�λ��
    private int current = -1;

    /**
     * <pre>
     * ԭ��
     * Design a stack that supports push, pop, top, and retrieving
     * the minimum element in constant time.
     * push(x) �C Push element x onto stack.
     * pop() �C Removes the element on top of the stack.
     * top() �C Get the top element.
     * getMin() �C Retrieve the minimum element in the stack.
     *
     * ��Ŀ����
     * ���һ��ջ��֧��push��pop��top���Ͳ�����С��Ԫ�ز���������ʱ�䣩
     *
     * ����˼·
     * ʹ��һ������ջ������ջ�е���СԪ�ء�
     * </pre>
     */
    public MinStack() {
        stack = new int[DEFAULT_SIZE];
        minIndex = new int[DEFAULT_SIZE];
    }

    public MinStack(int size) {
        stack = new int[size];
        minIndex = new int[size];
    }

    public void push(int x) {
        current++; // �ƶ���Ҫ�����λ��

        if (current >= stack.length) { // ����
            int[] tmp = new int[current * 2];
            System.arraycopy(stack, 0, tmp, 0, stack.length);
            stack = tmp;

            tmp = new int[current * 2];
            System.arraycopy(minIndex, 0, tmp, 0, minIndex.length);
            minIndex = tmp;
        }

        stack[current] = x; // ��������

        if (x < min) { // ����������Сֵ
            min = x;
            index = current; // ��¼[0, current]����С��Ԫ���±���index
        }

        minIndex[current] = index;
    }

    public void pop() {
        current--;
        if (current >= 0) {
            min = stack[minIndex[current]]; // ��������ջ�е���Сֵ
            index = minIndex[current]; // ������Сֵ������
        }
    }

    public int top() {

        if (current < 0) {
            throw new RuntimeException("No more data");
        }

        return stack[current];
    }

    public int getMin() {
        if (current < 0) {
            throw new RuntimeException("No more data");
        }

        return stack[minIndex[current]];
    }
}
