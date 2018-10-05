/**
 * Author: ������
 * Date: 2015-06-19
 * Time: 20:12
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
     * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
     * Find the minimum element.
     * You may assume no duplicate exists in the array.
     *
     * ��Ŀ���⣺
     * ����һ�����������������δ֪��ĳ�������������ת��
     * ������0 1 2 4 5 6 7���ܳ�Ϊ4 5 6 7 0 1 2����
     *
     * �ҵ���С��Ԫ�ء�
     * ����Լ��費�����ظ��������С�
     *
     * Կ��˼·��
     * �����������������Ϊ��������Ĳ��֣�ǰһ�����ֺͺ�һ�����ֲ���ǰһ�����򲿷�Ԫ�ض��Ⱥ�һ��Ԫ�ش�
     * ֻҪ�ҵ���һ��Ԫ�ر�ǰһ�������Ҫ�ҵ�Ԫ��
     * </pre>
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        // ��������
        if (nums == null || nums.length < 0) {
            throw new IllegalArgumentException();
        }

        return binarySearch(nums, 0, nums.length - 1);
    }

    public int binarySearch(int[] nums, int start, int end) {

        int mid = 0;

        while (start < end) {
            mid = start + ((end - start) >> 1);
//            System.out.println(mid + " " + nums[mid]);
            // ��һ������ǰ����С���ҵ���
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            // ˵���м�ֵ�ڵ�һ�������������
            else if (nums[mid] > nums[start]) {
                // ��ȡmid+1���п���num[mid]�ǵ�һ�����������е����һ��Ԫ��
                start = mid;
            }
            // ˵���м�ֵ�ڵڶ��������������
            else {
                // ��ȡmid-1���п���num[mid]�ǵڶ������������еĵ�һ��Ԫ��
                end = mid;
            }
        }

        // ˵�����������������
        return nums[0];
    }
}
