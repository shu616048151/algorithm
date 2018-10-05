/**
 * Author: ������
 * Date: 2015-06-22
 * Time: 12:05
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     *<pre>
     * Find the contiguous subarray within an array (containing at least one number)
     * which has the largest sum.
     *
     * For example, given the array [?2,1,?3,4,?1,2,1,?5,4],
     * the contiguous subarray [4,?1,2,1] has the largest sum = 6.
     *
     * ��Ŀ���⣺
     * ����������������ĺ�
     * ����˼·��
     * ��̬�滮���⣬��֪��ǰk��Ԫ�ص���������к�ΪmaxSub���Ѿ�����¼�����ˣ����Լ�һ����ʱ��sum��
     * �������˵�k+1���Ԫ�أ�����������������������ƣ��������k+1���Ԫ��֮ǰ�ĺ���С��0�ģ�
     * ��ô��������k+1���Ԫ�شӶ�ȥ��������������û�й��׵ģ����Կ��԰�sum ��0��
     *</pre>
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        // ����У��
        if (nums == null || nums.length < 1) {
            throw new IllegalArgumentException();
        }

        int max = Integer.MIN_VALUE;
        int curSum = 0;

        for (int i : nums) {
            // ��ǰ��С��0���ͽ���ǰֵ����curSum
            if (curSum <= 0){
                curSum = i;
            }
            // ��������ۼ�
            else {
                curSum += i;
            }

            // ����ϴ��ֵ
            if (max < curSum) {
                max = curSum;
            }
        }

        return max;
    }
}
