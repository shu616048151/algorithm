import java.util.Arrays;

/**
 * Author: ������
 * Date: 2015-06-17
 * Time: 20:27
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    private static class Node implements Comparable<Node> {
        int val;
        int idx;

        public Node() {
        }

        public Node(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node o) {
            if (o == null) {
                return -1;
            }
            return this.val - o.val;
        }
    }


    /**
     * <pre>
     * Given an array of integers, find two numbers such that they add up to a specific target number.
     * The function twoSum should return indices of the two numbers such that they add up to the target,
     * where index1 must be less than index2. Please note that your returned answers (both index1 and index2)
     * are not zero-based.
     * You may assume that each input would have exactly one solution.
     *
     * Input: numbers={2, 7, 11, 15}, target=9
     * Output: index1=1, index2=2
     *
     * ��Ŀ����
     * ����һ���������飬�ҳ�����������������ӵ�����ָ����Ŀ�����֡�
     * Ҫ���������twoSum����Ҫ�����ܹ���ӵ���Ŀ�����ֵ�����������������index1����ҪС��index2��
     * ��ע��һ�㣬�㷵�صĽ��������index1��index2�������ǻ���0��ʼ�ġ�����Լ���ÿһ������϶�ֻ��һ�������
     *
     * ����˼·
     * ����һ�����������飬�Ը������������ʹ������ָ�룬��ʼʱ�ֱ�ָ����������ˣ����������±��Ӧ��ֵ�Ƿ�
     * ����Ŀ��ֵ��������ھʹӸ��������ҳ���¼���±꣬����÷��ؽ�������ء�������ھ����ұߵ��±������ƣ�
     * ������һ��ƥ�䣬���С�ھ�����ߵ��±������ƶ���������һ��ƥ�䣬ֱ�����е����ݶ�������
     * </pre>
     *
     * @param nums
     * @param target
     * @return
     */

    public int[] twoSum(int[] nums, int target) {
        int[] result = {0, 0};

        Node[] tmp = new Node[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tmp[i] = new Node(nums[i], i);
        }

        Arrays.sort(tmp);

        int lo = 0;
        int hi = nums.length - 1;


        while (lo < hi) {
            if (tmp[lo].val + tmp[hi].val == target) {

                if (tmp[lo].idx > tmp[hi].idx) {
                    result[0] = tmp[hi].idx + 1;
                    result[1] = tmp[lo].idx + 1;
                } else {
                    result[0] = tmp[lo].idx + 1;
                    result[1] = tmp[hi].idx + 1;
                }
                break;
            } else if (tmp[lo].val + tmp[hi].val > target) {
                hi--;
            } else {
                lo++;
            }
        }
        return result;
    }
}
