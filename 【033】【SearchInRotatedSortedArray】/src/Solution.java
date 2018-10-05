/**
 * Author: ������
 * Date: 2015-06-21
 * Time: 14:48
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
     * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
     * You are given a target value to search. If found in the array return its
     * index, otherwise return -1.
     *
     * You may assume no duplicate exists in the array.
     *
     * ��Ŀ���⣺
     * ����һ�������������һ��δ֪�ĵ�������ת��������0 1 2 4 5 6 7���ܳ�Ϊ4 5 6 7 0 1 2����
     * ����һ��Ŀ��ֵ������������Ѱ��������ھͷ������Ӧ���±꣬���򷵻�-1��
     * ���������в������ظ�ֵ��
     *
     * ����˼·��
     * ����ת������Сֵ��λ��minIndex����LeetCode��153�� �������minIndex��Ϊ��˵�����ڷָ���
     * �����������飬����ǰһ���еĵ�һ��Ԫ�ض����ں�һ�������ÿһ��Ԫ�أ��ж�target����һ��������
     * ����ʹ�ö��������㷨���ң����minIndex=0��˵��ȫ�����򣬶�����������ж�����ң����ز��ҽ��
     * </pre>
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {

        if (nums != null && nums.length > 0) {

            // ����СԪ�ض�Ӧ���±�
            int minIndex = searchMinIndex(nums, 0, nums.length - 1);

            // ��������ȫ������
            if (minIndex == 0) {
                return binarySearch(nums, 0, nums.length - 1, target);
            }
            // �������ֲ���������,  �� 4 5 6 7 8 9 0 1 2 3
            else {
                // ��úͺ�һ��������������һ��Ԫ����ȣ����ض�Ӧ���±�
                if (nums[nums.length - 1] == target) {
                    return nums.length - 1;
                }
                // target�����ں�һ������������
                else if (nums[nums.length - 1] > target) {
                    return binarySearch(nums, minIndex, nums.length - 1, target);
                }
                // target������ǰһ������������
                else {
                    return binarySearch(nums, 0, minIndex - 1, target);
                }
            }
        }

        return -1;
    }

    /**
     * ��������
     *
     * @param nums   ����
     * @param start  ��ʼλ��
     * @param end    ����λ��
     * @param target ����Ŀ��
     * @return ƥ��Ԫ�ص��±�
     */
    public int binarySearch(int[] nums, int start, int end, int target) {

        int mid;
        while (start <= end) {
            mid = start + ((end - start) >> 1);

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    /**
     * ����СԪ�ص��±�
     *
     * @param nums  ����
     * @param start ��ʼλ��
     * @param end   ����λ��
     * @return ��СԪ�ص��±�
     */
    public int searchMinIndex(int[] nums, int start, int end) {

        int mid;
        while (start < end) {
            mid = start + ((end - start) >> 1);
            // ��һ������ǰ����С���ҵ���
            if (nums[mid] > nums[mid + 1]) {
                return mid + 1;
            }
            // ˵���м�ֵ�ڵ�һ�������������
            else if (nums[mid] > nums[start]) {
                start = mid;
            }
            // ˵���м�ֵ�ڵڶ��������������
            else {
                end = mid;
            }
        }

        // ˵�����������������
        return 0;
    }
}
