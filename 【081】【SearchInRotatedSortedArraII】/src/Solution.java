/**
 * Author: ������
 * Date: 2015-06-21
 * Time: 14:46
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Follow up for "Search in Rotated Sorted Array":
     * What if duplicates are allowed?
     * Would this affect the run-time complexity? How and why?
     * Write a function to determine if a given target is in the array
     *
     * ��Ŀ���⣺
     * "����ת����������ֵ"�ĺ�������������е�ֵ�����ظ�
     * дһ������ȷ��һ��������ֵ�Ƿ���������
     * </pre>
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        if (nums != null && nums.length > 0) {
            // ����СԪ�ض�Ӧ���±�
            int minIndex = findMinIndex(nums);

            // ��������ȫ������
            if (minIndex == 0) {
                return binarySearch(nums, 0, nums.length - 1, target);
            }
            // �������ֲ���������,  �� 4 5 6 7 8 9 0 1 2 3
            else {
                // ��úͺ�һ��������������һ��Ԫ����ȣ����ض�Ӧ���±�
                if (nums[nums.length - 1] == target) {
                    return true;
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

        return false;
    }

    /**
     * ��������
     *
     * @param nums   ����
     * @param start  ��ʼλ��
     * @param end    ����λ��
     * @param target ����Ŀ��
     * @return true�ҵ���falseû���ҵ�
     */
    public boolean binarySearch(int[] nums, int start, int end, int target) {

        int mid;
        while (start <= end) {
            mid = start + ((end - start) >> 1);

            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }


    public int findMinIndex(int[] nums) {
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
                return sequenceSearchMinIndex(nums, lo, hi);
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

        return mid;
    }

    /**
     * ˳�����������е���Сֵ���±꣬nums�����������鰴ĳ������ת������
     *
     * @param nums  ��������
     * @param start ��ʼλ��
     * @param end   ����λ��
     * @return ��Сֵ���±�
     */
    public int sequenceSearchMinIndex(int[] nums, int start, int end) {
        for (int i = start; i < end; i++) {
            if (nums[i] > nums[i + 1]) {
                return i + 1;
            }
        }
        return start;
    }
}
