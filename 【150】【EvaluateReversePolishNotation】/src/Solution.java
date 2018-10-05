import java.util.Queue;
import java.util.Stack;

/**
 * Author: ������
 * Date: 2015-06-20
 * Time: 06:58
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
     * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
     *
     * Some examples:
     * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
     * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
     *
     * ��Ŀ���⣺
     * �����沨����ʽ��ֵ����Ч��������ǣ�+��-��*��/��ÿ��������Ҫô��һ������Ҫô����һ�����ʽ
     *
     * ����˼·��
     * ʹ��ջ���в���
     * </pre>
     *
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        // ����У��
        if (tokens == null || tokens.length < 1) {
            throw new IllegalArgumentException();
        }

        int op1;
        int op2;
        // ������ջ
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            // ˵�����������Ҫȡջ������Ԫ�ؽ�������
            if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)) {
                // ȡջ��Ԫ��
                op2 = stack.pop();
                op1 = stack.pop();

                // ��������
                switch (token.charAt(0)) {
                    case '+':
                        op1 += op2;
                        break;
                    case '-':
                        op1 -= op2;
                        break;
                    case '*':
                        op1 *= op2;
                        break;
                    case '/':
                        op1 /= op2;
                        break;
                }
                // �����ջ
                stack.push(op1);
            }
            // ˵���ǲ���������ջ
            else {
                stack.push(Integer.parseInt(token));
            }
        }

        // ջ�����ֻ��ʣ��һ��Ԫ�أ��Ǿ���������Ľ��
        return stack.pop();
    }
}
