/**
 * Author: ������
 * Date: 2015-08-21
 * Time: 16:40
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * ԭ��
     * Given a sorted array, remove the duplicates in place such that each element
     * appear only once and return the new length.
     * Do not allocate extra space for another array, you must do this in place
     * with constant memory.
     * For example,
     * Given input array nums = [1,1,2],
     * Your function should return length = 2, with the first two elements of nums
     * being 1 and 2 respectively. It doesn��t matter what you leave beyond the new length.
     *
     * ��Ŀ����
     * ����һ����������飬�������е��ظ�Ԫ��ȥ������ͬ��ֻ����һ�������ҷ��������µ�Ԫ�ظ�����
     * ��Ҫ����һ���µ����������������ڳ���ʱ���ڽ���������
     *
     * ����˼·
     * �ӵڶ���Ԫ�ؿ�ʼ������Ϊ��ǰ�����Ԫ�أ������ǰԪ��������ǰһ��Ԫ����ͬ��ɾ�����Ԫ�أ�
     * �����ͬ�ͽ����ƶ�����ȷ��λ�ã������������Ԫ���˸�����
     * </pre>
     *
     * @param A
     * @return
     */
    public int removeDuplicates(int[] A) {

        if (A.length == 0) {
            return 0;
        }

        int index = 0;//[0,index]ֻ��¼�����г��ֵİ���С�����Ψһһ�������Ѿ��ź�����
        int next = 1;

        // �㷨˼�룺��index֮��ı�A[index]������������ҵ����ƶ���A[index+1]����
        // index�ƶ�����һ��λ�ã�next�ƶ�����һ��λ�ã����ұ�A[index]�����

        while (next < A.length) {
            while (next < A.length && A[index] == A[next]) { // �Ҳ�������������
                next++;
            }

            if (next < A.length) {
                index++;
                A[index] = A[next];
                next++;
            }
        }
        return index + 1;
    }
}
