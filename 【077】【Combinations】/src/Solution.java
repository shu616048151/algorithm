import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: ������
 * Date: 2015-08-21
 * Time: 19:39
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    private List<List<Integer>> result;
    private List<Integer> l;

    /**
     * <pre>
     * ԭ��
     * Given two integers n and k, return all possible combinations of k numbers out of 1 �� n.
     * For example,
     * If n = 4 and k = 2, a solution is:
     *
     * [
     *  [2,4],
     *  [3,4],
     *  [2,3],
     *  [1,2],
     *  [1,3],
     *  [1,4],
     * ]
     *
     * ��Ŀ����
     * ����������n��k�����1-n��k������������ϡ�
     *
     * ����˼·
     * ���õݹ���η�������⣬������롣
     * </pre>
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        result = new LinkedList<>();

        if (n > 0 && k > 0 && n >= k) {
            l = new LinkedList<>();
            combine(1, n, k);
        }

        return result;
    }

    /**
     * �����
     *
     * @param start ��ѡ�������ʼλ��
     * @param end   ��ѡ������Ľ���λ��
     * @param num   ��[start, end]��ѡ���������Ŀ
     */
    private void combine(int start, int end, int num) {

        if (num == 0) {
            List<Integer> tmp = new ArrayList<>();
            for (Integer i : l) {
                tmp.add(i);
            }

            result.add(tmp);
            return;
        }

        int endFirst = end - num + 1; // ��һ��������ѡ������ֵ
        for (int i = start; i <= endFirst; i++) {
            l.add(i);
            combine(i + 1, end, num - 1);
            l.remove(new Integer(i));
        }
    }
}
