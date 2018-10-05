import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: ������
 * Date: 2015-06-22
 * Time: 11:13
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Given n pairs of parentheses, write a function to generate all combinations
     * of well-formed parentheses.
     *
     * For example, given n = 3, a solution set is:
     * "((()))", "(()())", "(())()", "()(())", "()()()"
     *
     * ��Ŀ���⣺
     * ����n�����ţ��������������ȷ�����
     *
     * ����˼·��
     * ���õݹ������
     * </pre>
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        // �������Ķ���
        List<String> result = new ArrayList<>();
        // ����������0
        if (n > 0) {
            // ��ʹ������
            char[] parentheses = new char[2 * n];
            // �������
            solve(n, n, parentheses, result);
        }
        return result;
    }

    /**
     * @param left        ʣ����õ���������
     * @param right       ʣ����õ���������
     * @param parentheses ����һ��Ϊֹ����ʹ�õ����
     * @param result      ��Ž���ļ���
     */
    public void solve(int left, int right, char[] parentheses, List<String> result) {

        // ʣ�µ�����������С��0������ÿ��ʣ�µ���������������С����������
        if (left < 0 || right < 0 || right < left) {
            // ʲô��������
        }
        // �������Ŷ���ʹ������
        else if (left == 0 && right == 0) {
            result.add(new String(parentheses));
        }
        // ����ʹ��
        else {
            // ��ǰʹ�õ�λ��
            int idx = parentheses.length - left - right;
            // ʹ��������
            parentheses[idx] = '(';
            // �ݹ����
            solve(left - 1, right, parentheses, result);
            // ʹ��������
            parentheses[idx] = ')';
            solve(left, right - 1, parentheses, result);
        }
    }
}
