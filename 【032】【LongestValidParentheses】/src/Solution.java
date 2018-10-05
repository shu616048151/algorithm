import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Author: ������
 * Date: 2015-06-25
 * Time: 09:12
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Given a string containing just the characters '(' and ')',
     * find the length of the longest valid (well-formed) parentheses substring.
     *
     * For "(()", the longest valid parentheses substring is "()", which has length = 2.
     * Another example is ")()())", where the longest valid parentheses substring is "()()",
     * which has length = 4.
     *
     * ��Ŀ���⣺
     * ����һ���ַ�����ֻ����С���źţ�����ĺϷ���С���ŵ���Ŀ
     *
     * ����˼·��
     * ʹ��ջ��ʵ��
     * </pre>
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        // ���ڼ�¼��ƥ��������ź������ŵ�λ��
        Stack<Integer> st = new Stack<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {

            // ���ǵ�ǰ�ַ��������ţ����Ҽ�¼ջ�ǿգ�����ǰһ���ַ���������
            if (s.charAt(i) == ')' && !st.isEmpty() && s.charAt(st.peek()) == '(') {
                // �����ų�ջ
                st.pop();
                // �����ֵ
                // ��ʱ��(ƥ���)�Ѿ���ջ������ջҪôΪ�գ�Ҫô���뵱ǰ)�����)
                // Ҫô���뵱ǰ)�ڶ�����(
                max = Math.max(max, i - ((st.isEmpty()) ? -1 : st.peek()));
            }
            // ��������ͽ��ַ���ջ
            else {
                st.push(i);
            }
        }

        return max;
    }
}
