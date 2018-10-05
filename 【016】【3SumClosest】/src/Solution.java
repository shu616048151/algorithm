import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: ������
 * Date: 2015-06-21
 * Time: 09:29
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Given an array S of n integers, find three integers in S such that the sum is
     * closest to a given number, target. Return the sum of the three integers. You
     * may assume that each input would have exactly one solution.
     *
     * For example,
     * given array S = {-1 2 1 -4}, and target = 1.
     * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
     *
     * ��Ŀ���⣺
     * ��������n����������S���ҵ�S�е������������Ӷ�ʹ֮����ӽ�����������
     * ���������������ܺ͡�����Լ���ÿ�����뽫��һ��ȷ�еĽ����
     *
     * ����˼·��
     * ��3sum�������
     * </pre>
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {

        // ��¼��С�Ĳ�ֵ
        long minDiff = Long.MAX_VALUE;
        // ��¼��С��ֵ��Ӧ�����������ͺ�
        long result = 0;
        // ÿ����õĲ�ֵ
        long diff;
        // ÿ����õ����������ĺ�
        long sum;

        // �ȶ������������
        Arrays.sort(nums);


        // i��ʾ����ȡ��i������Ϊ���
        for (int i = 0; i < nums.length - 2; i++) {
            // �ڶ��������ܵ���ʼλ��
            int j = i + 1;
            // �������������ǽ���λ��
            int k = nums.length - 1;

            while (j < k) {
                // ��ǰ�������ĺ�
                sum = nums[j] + nums[k] + nums[i];
                // ��ǰ����Ŀ���֮��Ĳ�ֵ
                diff = Math.abs(target - sum);

                // ��ֵΪ0��ֱ�ӷ���
                if (diff == 0) {
                    return (int) sum;
                }

                // �����ǰ�Ĳ�ֵ��֮ǰ��¼�Ĳ�ֵС
                if (diff < minDiff) {
                    // ������С�Ĳ�ֵ
                    minDiff = diff;
                    // ������С��ֵ��Ӧ�ĺ�
                    result = sum;

                    // ���ϵ���������һ��Ԫ�ش���ʱ��Ч
                }


                // �ʹ���target
                if (sum > target) {
                    k--;
                }
                // ��С��target
                else {
                    j++;
                }
            }
        }

        return (int) result;
    }
}
