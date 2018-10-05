/**
 * Author: ������
 * Date: 2015-06-21
 * Time: 15:21
 * Declaration: All Rights Reserved !!!
 */
public class Solution {


    /**
     * <pre>
     * Follow up for "Find Minimum in Rotated Sorted Array":
     * What if duplicates are allowed?
     * Would this affect the run-time complexity? How and why?
     * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
     *
     *
     * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
     * Find the minimum element.
     * The array may contain duplicates.
     *
     * ��Ŀ���⣺
     * ��������ת�����������Сֵ���ĺ����������ظ�Ԫ�أ�����������������Ȼ�ֲ�����
     *
     * ����˼·��
     * ��������������㷨���в���
     *
     * </pre>
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        // ����У��
        if (nums == null || nums.length < 1) {
            throw new IllegalArgumentException();
        }

        int lo = 0;
        int hi = nums.length - 1;
        int mid = 0;

        // �����ų�����ȫ����������
        while (nums[lo] >= nums[hi]) {

            // ���ֻ������Ԫ�أ����غ�һ��
            if (hi - lo == 1) {
                mid = hi;
                break;
            }

            mid = lo + ((hi - lo) >> 1);

            if (nums[mid] == nums[lo] && nums[mid] == nums[hi]) {
                // ֻ�ܲ���˳���������������ܲ���lo++��hi--�ķ�ʽ
                // ��Ϊlo������ǰһ��������������һ��
                // hiҲ�����Ǻ�һ����������ĵ�һ��
                return sequenceSearch(nums, lo, hi);
            }

            // ���mid��ǰһ������������
            if (nums[mid] >= nums[lo]) {
                lo = mid;
            }
            // ���mid�ں�һ������������
            else if (nums[mid] <= nums[hi]) {
                hi = mid;
            }

        }


        return nums[mid];
    }

    /**
     * ˳�����������е���Сֵ��nums�����������鰴ĳ������ת������
     *
     * @param nums  ��������
     * @param start ��ʼλ��
     * @param end   ����λ��
     * @return ��Сֵ
     */
    public int sequenceSearch(int[] nums, int start, int end) {
        for (int i = start; i < end; i++) {
            if (nums[i] > nums[i + 1]) {
                return nums[i + 1];
            }
        }
        return nums[start];
    }
}
