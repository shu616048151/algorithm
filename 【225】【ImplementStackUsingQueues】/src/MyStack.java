import java.util.LinkedList;
import java.util.List;

/**
 * <pre>
 * Implement the following operations of a stack using queues.
 *   - push(x)  -- Push element x onto stack.
 *   - pop()    -- Removes the element on top of the stack.
 *   - top()    -- Get the top element.
 *   - empty()  -- Return whether the stack is empty.
 *
 * Notes:
 *   - You must use only standard operations of a queue -- which means only push
 *          to back, peek/pop from front, size, and is empty operations are valid.
 *   - Depending on your language, queue may not be supported natively. You may
 *          simulate a queue by using a list or deque (double-ended queue), as
 *          long as you use only standard operations of a queue.
 *   - You may assume that all operations are valid (for example, no pop or top
 *          operations will be called on an empty stack).
 *
 *  ��Ŀ���⣺
 *  ʹ�ö���ʵ��ջ����
 *   - push(x)  -- Ԫ����ջ
 *   - pop()    -- Ԫ�س�ջ
 *   - top()    -- ȡջ��Ԫ��ֵ
 *   - empty()  -- �ж�ջ�Ƿ�Ϊ��
 *  ע�⣺
 *   - ֻ��ʹ�ö��еı�׼�������Ƚ��ȳ��������Ԫ�������ж϶����Ƿ�Ϊ��
 *   - ���ڱ������ԭ����Щ���Բ�֧��Ħ���У�����ʹ�������˫��������棬������ʹ�ñ�׼�Ķ��в���
 *   - ����Լ������еĲ������ǺϷ��ģ�����������Ϊ��ʱ������Ԫ�س�ջ����ջ��Ԫ�صĲ���
 *
 * ����˼·��
 * ������������ģ��һ��ջ
 * </pre>
 * <p>
 * Author: ������
 * Date: 2015-06-22
 * Time: 20:45
 * Declaration: All Rights Reserved !!!
 */
public class MyStack {

    // ά���������У���������һ������Ϊ�գ�Ϊpop��top����׼��
    private List<Integer> aList = new LinkedList<>();
    private List<Integer> bList = new LinkedList<>();


    // Push element x onto stack.
    public void push(int x) {
        // ���aList�ǿգ��ͽ�x��ӵ�aList��
        if (!aList.isEmpty()) {
            aList.add(x);
        }
        // ��������ӵ�bList��
        else {
            bList.add(x);
        }
    }

    // Removes the element on top of the stack.
    public void pop() {

        // ����������������һ��Ϊ�գ���aList���÷ǿ�
        if (aList.isEmpty()) {
            List<Integer> tmp = bList;
            bList = aList;
            aList = tmp;
        }

        // �����һ��Ԫ���ⶼת�Ƶ�bList��
        while (aList.size() > 1) {
            bList.add(aList.remove(0));
        }

        // ɾ�����һ��Ԫ�أ���Ӧ������ջ��ջ��Ԫ�أ�
        aList.clear();
    }

    // Get the top element.
    public int top() {

        // ����������������һ��Ϊ�գ���aList���÷ǿ�
        if (aList.isEmpty()) {
            List<Integer> tmp = bList;
            bList = aList;
            aList = tmp;
        }

        // �����һ��Ԫ���ⶼת�Ƶ�bList��
        while (aList.size() > 1) {
            bList.add(aList.remove(0));
        }

        bList.add(aList.get(0));
        return aList.remove(0);
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return aList.isEmpty() && bList.isEmpty();
    }
}
