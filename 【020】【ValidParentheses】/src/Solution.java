import java.util.Deque;
import java.util.LinkedList;

/**
 * Author: ������
 * Date: 2015-08-21
 * Time: 16:32
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * ԭ��
     * Given a string containing just the characters ��(��, ��)��, ��{��, ��}��, ��[�� and ��]��,
     * determine if the input string is valid.
     * The brackets must close in the correct order, ��()�� and ��()[]{}�� are all valid
     * but ��(]�� and ��([)]�� are not.
     *
     * ��Ŀ����
     * ����һ��ֻ����(��, ��)��, ��{��, ��}��, ��[�� �͡�]�����ַ�������֤���Ƿ�����Ч�ġ�
     * ���ű�����ԣ�����Ҫ����ȷ��˳��
     *
     * ����˼·
     * ��һ��ջ������������Ŵ����д�������������ž���ջ������������ž���ջ��Ԫ�ؿ��Ƿ����һ�����ţ�
     * ��ɾ͵��������Ҵ�����һ����������ţ������ƥ���ֱ�ӷ��ؽ����
     * </pre>
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        int index = 0;
        Character top;
        while (index < s.length()) {
            Character c = s.charAt(index);
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.addFirst(c);
                    break;
                case ')':

                    if (stack.isEmpty()) {
                        return false;
                    }

                    top = stack.getFirst();
                    if (top == '(') {
                        stack.removeFirst();
                    } else if (top == '[' || top == '{') {
                        return false;
                    } else {
                        stack.addFirst(c);
                    }
                    break;
                case ']':

                    if (stack.isEmpty()) {
                        return false;
                    }

                    top = stack.getFirst();
                    if (top == '[') {
                        stack.removeFirst();
                    } else if (top == '(' || top == '{') {
                        return false;
                    } else {
                        stack.addFirst(c);
                    }
                    break;
                case '}':

                    if (stack.isEmpty()) {
                        return false;
                    }

                    top = stack.getFirst();
                    if (top == '{') {
                        stack.removeFirst();
                    } else if (top == '[' || top == '(') {
                        return false;
                    } else {
                        stack.addFirst(c);
                    }
                    break;
                default:
                    return false;
            }

            index++;
        }

        return stack.isEmpty();
    }
}
