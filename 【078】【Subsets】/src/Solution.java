import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: ������
 * Date: 2015-08-21
 * Time: 19:41
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    private List<List<Integer>> result;
    private List<Integer> l;
    private int[] set;
    private int num; // ��set�л���Ҫ��ѡ���Ԫ�ظ���

    /**
     * <pre>
     * ԭ��
     * Given a set of distinct integers, nums, return all possible subsets.
     * Note:
     * Elements in a subset must be in non-descending order.
     * The solution set must not contain duplicate subsets.
     * For example,
     * If nums = [1,2,3], a solution is:
     *
     * [
     *  [3],
     *  [1],
     *  [2],
     *  [1,2,3],
     *  [1,3],
     *  [2,3],
     *  [1,2],
     *  []
     * ]
     *
     * ��Ŀ����
     * ����һ����ͬ���ֵ����飬�������������Ӽ���
     *
     * ����˼·
     * �ȶ������е�Ԫ�ؽ�������Ȼ�����õݹ���η�������⡣
     * </pre>
     *
     * @param S
     * @return
     */
    public List<List<Integer>> subsets(int[] S) {
        result = new LinkedList<>();

        if (S != null) {
            l = new ArrayList<>();

            // ��S����������
            quickSort(S, 0, S.length - 1);

            set = S;
            for (int i = 0; i <= S.length; i++) {
                num = i;
                subset(0);
            }
        }

        // ���գ��ӿ���������
        set = null;
        l = null;

        return result;
    }

    /**
     * ��Ԫ�ظ�������num���Ӽ���
     *
     * @param start ʣ���Ҫ��ѡ��num��Ԫ���У���һ������С�±�
     */
    public void subset(int start) {
        if (num == 0) {
            List<Integer> tmp = new ArrayList<>();
            for (Integer i : l) {
                tmp.add(i);
            }

            result.add(tmp);
            return;
        }

        int endFirst = set.length - num; // ʣ���Ҫ��ѡ��num��Ԫ���У���һ��������±�
        for (int i = start; i <= endFirst; i++) {
            l.add(set[i]);
            num--;
            subset(i + 1);
            num++;
            l.remove(new Integer(set[i]));
        }
    }

    private void quickSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int mid = getMid(arr, lo, hi);
            quickSort(arr, lo, mid - 1);
            quickSort(arr, mid + 1, hi);
        }
    }

    private int getMid(int[] arr, int lo, int hi) {
        int tmp = arr[lo];
        while (lo < hi) {
            while (lo < hi && arr[hi] > tmp) {
                hi--;
            }
            arr[lo] = arr[hi];

            while (lo < hi && arr[lo] < tmp) {
                lo++;
            }

            arr[hi] = arr[lo];
        }

        arr[lo] = tmp;
        return lo;
    }
}
