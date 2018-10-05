/**
 * Author: ������
 * Date: 2015-06-17
 * Time: 22:00
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * You are a professional robber planning to rob houses along a street. Each house has a
     * certain amount of money stashed, the only constraint stopping you from robbing each
     * of them is that adjacent houses have security system connected and it will automatically
     * contact the police if two adjacent houses were broken into on the same night.
     * <p>
     * Given a list of non-negative integers representing the amount of money of each house,
     * determine the maximum amount of money you can rob tonight without alerting the police.
     * <p>
     * ��Ŀ���⣺����һ��רҵǿ�����ƻ�����һ���ִ�ҽ��ᡣÿ�䷿�ݶ�������һ�������Ľ�Ǯ��Ψһ����ֹ��
     * ��ٵ�Լ���������ǣ����ڷ���֮���а�ȫϵͳ���������ͬһ���������������ڵķ��ݱ����룬���Ǿͻ���
     * �����羯�죬��˲����Դ�����ڵķ��ݡ�
     * <p>
     * ����һ�зǸ�����������ÿ�䷿�ݵĽ�Ǯ����������ڲ����������ǰ����һ���������Դ�ٵ��Ľ�Ǯ����
     * ����˼·����̬�滮��Dynamic Programming��
     * ״̬ת�Ʒ��̣�dp[i] = max(dp[i - 2], dp[i - 3]) + num[i] ��A��
     * ���У�dp[i]��ʾ��ٵ���i�䷿��ʱ�ۼ�ȡ�õĽ�Ǯ���ֵ��
     * (�� i ��λ�õ� max ֵ���� max(i-2, i-3) ���� i λ�õ�ֵ�������Դ�����)
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        // ��������е�Ԫ�ظ���������2�������ڡ�A��ʽ��i=2��dp[2-3]������
        if (nums.length > 2) {
            nums[2] += nums[0];
        }

        // �ӵ��ĸ�Ԫ�ؿ�ʼ����
        int i = 3;
        for (; i < nums.length; i++) {
            // �����i��Ԫ�ص����ֵ
            nums[i] += Math.max(nums[i - 2], nums[i - 3]);
        }

        // ���ֻ��һ��Ԫ�أ��������Ԫ��ֵ
        if (nums.length == 1) {
            return nums[0];
        }
        // ������Ԫ�ط������нϴ��ֵ
        else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // ��������Ԫ�أ����ֵ��ĩβ����֮�䣬�����ķ���
        else {
            return Math.max(nums[i - 1], nums[i - 2]);
        }
    }
}
