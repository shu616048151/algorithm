/**
 * Author: ������
 * Date: 2015-08-21
 * Time: 16:55
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * ԭ��
     * Given a sorted array of integers, find the starting and ending position of a given target value.
     * Your algorithm��s runtime complexity must be in the order of O(log n).
     * If the target is not found in the array, return [-1, -1].
     * For example,
     * Given [5, 7, 7, 8, 8, 10] and target value 8,
     * return [3, 4].
     *
     * ��Ŀ����
     * ����һ���ź�������飬ͬʱ����һ��Ҫ���ҵ�ֵ ���ҳ�������������еĳ�������ʼ�ͽ���λ�á�
     * �㷨��ʱ�临�Ӷ�Ҫ��Ϊlog(N)��
     * ���û���ҵ��ͷ���[-1, -1]
     *
     * ����˼·
     * �ٶ������ǵ�������ģ����ö��ֲ����㷨���������Ƿ�������������������ھͷ���[-1,-1]
     * ������ھͷֱ�����������һ�γ����ֵ�λ�ú��ʼ���ֵ�λ�á��������ֵ�λ��ʱ���ȴ���
     * �����һ��λ�ÿ�ʼ�ң�������ڴ��ҵ�ֵ����ǰ��һ��λ�ã������ھ�ǰ��2������2��ָ�������ӣ�
     * ���С�ھ��˻ص�ԭ��λ�õĺ�һ�����в��ң����°�1��2��4�����������ӵķ�ʽ���У�ֱ���ҵ�Ϊֹ��
     * ���������ȵ�Ԫ��Ҳ��һ���ġ�
     * </pre>
     *
     * @param A
     * @param target
     * @return
     */
    public int[] searchRange(int[] A, int target) {

        if (A == null || A.length == 0) {
            return new int[]{-1, -1};
        }

        int lo = 0;
        int hi = A.length - 1;
        int mi = 0;
        // �����������Ƿ����ֵΪtarget��Ԫ��
        while (lo <= hi) {
            mi = lo + (hi - lo) / 2;
            if (target < A[mi]) {
                hi = mi - 1;
            } else if (target > A[mi]) {
                lo = mi + 1;
            } else {
                break;
            }

        }

        if (A[mi] != target) {
            return new int[]{-1, -1};
        }

        lo = searchFirst(A, 0, mi, target);
        hi = searchLast(A, mi, A.length - 1, target);

        return new int[]{lo, hi};
    }

    /**
     * ��target���ȳ��ֵ�λ�ã����ҵķ�Χ��[lo, hi]��A[hi]����target��AΪ��������
     *
     * @param A      �����ҵ�����
     * @param lo     ���ҵ���ʼλ��
     * @param hi     ���ҵĽ���λ��
     * @param target ���ҵ�ֵ
     * @return target���ȳ��ֵ�λ��
     */
    private int searchFirst(int[] A, int lo, int hi, int target) {

        int gap = 1;
        do {
            hi -= gap;
            if (hi < lo || A[hi] != target) {
                hi += gap;

                if (hi <= lo || A[hi - 1] != target) {
                    return hi;
                } else {
                    gap = 1;
                    hi--;
                }
            } else {// ����һ�ε�λ�ú���gap����Ȼ���
                gap *= 2;
            }
        } while (true);

    }

    /**
     * ��target�����ֵ�λ�ã����ҵķ�Χ��[lo, hi]��A[lo]����target��AΪ��������
     *
     * @param A      �����ҵ�����
     * @param lo     ���ҵ���ʼλ��
     * @param hi     ���ҵĽ���λ��
     * @param target ���ҵ�ֵ
     * @return target�����ֵ�λ��
     */
    private int searchLast(int[] A, int lo, int hi, int target) {
        int gap = 1;
        do {
            lo += gap;
            if (lo > hi || A[lo] != target) {
                lo -= gap;

                if (lo >= hi || A[lo + 1] != target) {
                    return lo;
                } else {
                    gap = 1;
                    lo++;
                }
            } else {// ����һ�ε�λ��ǰ��gap����Ȼ���
                gap *= 2;
            }
        } while (true);
    }
}
