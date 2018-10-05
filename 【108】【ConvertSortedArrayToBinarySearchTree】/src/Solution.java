/**
 * Author: ������
 * Date: 2015-06-22
 * Time: 12:56
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Given an array where elements are sorted in ascending order,
     * convert it to a height balanced BST.
     *
     * ��Ŀ���⣺
     * ����һ�������������飬����ת����һ���߶�ƽ�������
     *
     * ����˼·��
     * ���õݹ���η�
     * </pre>
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        // ��������
        if (nums == null || nums.length < 1) {
            return null;
        }

        // �ݹ���η����
        return solve(nums, 0, nums.length - 1);
    }

    /**
     * �ݹ������ⷽ��
     *
     * @param nums  ������������
     * @param start ��ʼλ��
     * @param end   ����λ��
     * @return �����
     */
    public TreeNode solve(int[] nums, int start, int end) {
        // ����δ���������
        if (start <= end) {
            // �Ҳ�λ��
            int mid = start + ((end - start) >> 1);
            // ��������
            TreeNode root = new TreeNode(nums[mid]);
            // ��������
            root.left = solve(nums, start, mid - 1);
            // ��������
            root.right = solve(nums, mid + 1, end);
            // ���ؽ��
            return root;
        }

        return null;
    }
}
