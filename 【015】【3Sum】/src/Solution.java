import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: ������
 * Date: 2015-06-20
 * Time: 21:46
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
     * Find all unique triplets in the array which gives the sum of zero.
     *
     * Note:
     * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a �� b �� c)
     * The solution set must not contain duplicate triplets.
     *
     * For example, given array S = {-1 0 1 2 -1 -4},
     * A solution set is:
     * (-1, 0, 1)
     * (-1, -1, 2)
     *
     * ��Ŀ���⣺
     * ����һ��n��Ԫ�ص����飬�Ƿ����a��b��c����Ԫ�أ�ʹ�õ�a+b+c=0���ҳ����з��������������Ԫ��
     *
     * ע�⣺
     *   - ��Ԫ���е�Ԫ�ر����Ƿǵݼ���
     *   - ������ܰ����ظ�Ԫ��
     *
     * ����˼·��
     * ������ 2sum���� �Ļ����������3sum���⣬����3sum�����Ŀ����target��ÿ�δ�������ѡ��һ����k��
     * ��ʣ�µ�������Ŀ�����target-k��2sum���⡣������Ҫע������и�С��trick�������Ǵ�������ѡ��
     * ��i��ʱ������ֻ��Ҫ����ֵ�дӵ�i+1�������һ����Χ���������2sum���⡣
     *
     * ������ѡ��һ���͵ڶ�����������������ΪA[],�ܹ���n��Ԫ��A1��A2....An������Ȼ����ѡ��A1ʱ��
     * ������������[A2~An]����Ŀ��λtarget-A1��2sum���⣬����Ҫ֤�����ǵ�ѡ��A2ʱ������ֻ��Ҫ��
     * ������[A3~An]�м���Ŀ��λtarget-A2��2sum���⣬��������������[A1,A3~An]�У�֤�����£�
     * ������������[A1,A3~An]Ŀ��λtarget-A2��2sum�����У�����A1 + m = target-A2��mΪA3~An��
     * ��ĳ����������A2 + m = target-A1����պ��ǡ�����������[A3~An],Ŀ��λtarget-A1��2sum���⡱
     * ��һ���⡣�������൱�ڶ�����3sum��������A1+A2+m = target�ظ������ˡ����Ϊ�˱����ظ����㣬
     * ��������[A1��A3~An]�У����԰�A1ȥ������������Ŀ����target-A2��2sum���⡣
     *
     * ���ڱ���Ҫ�������ӽ��⣬ֻ��Ҫ���浱ǰ���Լ���ǰ���Ŀ��ľ��룬����µĽ���ӽ�������½⡣
     * �㷨���Ӷ�ΪO��n^2��;
     * </pre>
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();

        if (nums != null && nums.length > 2) {
            // �ȶ������������
            Arrays.sort(nums);
            // i��ʾ����ȡ��i������Ϊ���
            for (int i = 0; i < nums.length - 2; ) {
                // �ڶ��������ܵ���ʼλ��
                int j = i + 1;
                // �������������ǽ���λ��
                int k = nums.length - 1;

                while (j < k) {
                    // ����ҵ����������Ľ�
                    if (nums[j] + nums[k] == -nums[i]) {
                        // �������ӵ����������
                        List<Integer> list = new ArrayList<>(3);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        result.add(list);

                        // �ƶ�����һ��λ�ã�����һ���
                        k--;
                        j++;

                        // ���������ҵ�һ����֮ǰ���������ͬ�������±�
                        while (j < k && nums[j] == nums[j - 1]) {
                            j++;
                        }
                        // ���������ҵ�һ����֮ǰ���������ͬ�������±�
                        while (j < k && nums[k] == nums[k + 1]) {
                            k--;
                        }
                    }
                    // �ʹ���0
                    else if (nums[j] + nums[k] > -nums[i]) {
                        k--;
                        // ���������ҵ�һ����֮ǰ���������ͬ�������±�
                        while (j < k && nums[k] == nums[k + 1]) {
                            k--;
                        }
                    }
                    // ��С��0
                    else {
                        j++;
                        // ���������ҵ�һ����֮ǰ���������ͬ�������±�
                        while (j < k && nums[j] == nums[j - 1]) {
                            j++;
                        }
                    }
                }

                // ָ����һ��Ҫ�������
                i++;
                // ���������ҵ�һ����֮ǰ���������ͬ�������±�
                while (i < nums.length - 2 && nums[i] == nums[i - 1]) {
                    i++;
                }
            }
        }

        return result;
    }
}
