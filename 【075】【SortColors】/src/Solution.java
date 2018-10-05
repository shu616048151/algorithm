/**
 * Author: ������
 * Date: 2015-08-21
 * Time: 19:37
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * ԭ��
     * Given an array with n objects colored red, white or blue, sort them so that objects
     * of the same color are adjacent, with the colors in the order red, white and blue.
     * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
     * and blue respectively.
     * Note:
     * You are not suppose to use the library��s sort function for this problem.
     *
     * ��Ŀ����
     * ����һ���������飬�����Ǻ�ɫ����ɫ����ɫ������ɫ�������򣬺죬�ף�����
     * ʹ��0��1��2�ֱ����죬�ף�����
     * ע�⣺����ʹ�ÿ⺯����������
     *
     * ����˼·
     * ���������ɨ�裬��¼1�ĸ�������������ĺ͡�ɨ�������Եó�1����Ŀt��2����Ŀ(sum-t)/2��
     * �����Եó�0����Ŀ�������Ӹ���0��1��2����Ŀ�ٶ������������ֵ��
     * </pre>
     *
     * @param A
     */
    public void sortColors(int[] A) {

        if (A == null) {
            return;
        }

        int count = 0; // ͳ��1�ĸ���
        int sum = 0; // ͳ������ĺ�

        for (int i : A) {
            if (i == 1) {
                count++;
            }

            sum += i;
        }

        sum = (sum - count) / 2; // ����2����Ŀ

        count = A.length - count - sum; // 1��ʼ���ֵ�λ��

        sum = A.length - sum; // 2��ʼ���ֵ�λ��

        for (int i = 0; i < count; i++) {
            A[i] = 0;
        }

        for (int i = count; i < sum; i++) {
            A[i] = 1;
        }

        for (int i = sum; i < A.length; i++) {
            A[i] = 2;
        }
    }
}
