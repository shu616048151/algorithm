/**
 * Author: ������
 * Date: 2015-06-30
 * Time: 07:25
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Given n non-negative integers a1, a2, ..., an, where each represents
     * a point at coordinate (i, ai). n vertical lines are drawn such that
     * the two endpoints of line i is at (i, ai) and (i, 0). Find two lines,
     * which together with x-axis forms a container, such that the container
     * contains the most water.
     *
     * Note: You may not slant the container.
     *
     * ��Ŀ���⣺
     * ����������Ȼ�����������Լ�X�ṹ�ɵ���������������ˮ��
     *
     * ����˼·��
     * ʹ��̰���㷨��
     *      1.���ȼ��������ҵ���ȡ����ݻ�������Ϊ i, j (�ٶ�i<j)��
     *      ��ô�õ�������ݻ� C = min( ai , aj ) * ( j- i) ��
     *
     *      2.�������ǿ���ôһ�����ʣ�
     *          ��: �� j ���Ҷ�û��һ���߻�����ߣ�������� k |( j<k && ak > aj) ��
     *          ��ô  �� ak > aj������ min(ai, aj, ak) =min(ai, aj) ��
     *          ������i, k���ɵ��������ݻ�C' = min(ai, aj) * (k - i) > C��
     *          ��C����ֵì�ܣ����Ե�֤j�ĺ�߲����б������ߵ��ߣ�
     *
     *          ��:ͬ����i�����Ҳ�����б����ߵ��ߣ���˵��ʲô�أ�
     *          �������Ŀǰ�õ��ĺ�ѡ�� ��Ϊ x, y�����ߣ�x< y)����ô�ܹ��õ���
     *          �������ݻ����µ������߱�Ȼ��[x, y]�����ڲ��� ax' >= ax , ay' >= ay;
     *
     *      3.�������Ǵ���ͷ���м俿£��ͬʱ���º�ѡֵ�������������ʱ�����ȴ�
     *      x, y�н�С�ı߿�ʼ������
     * </pre>
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {

        // ����У��
        if (height == null || height.length < 2) {
            return 0;
        }


        // ��¼���Ľ��
        int result = 0;

        // ��ߵ�����
        int left = 0;
        // �ұߵ�����
        int right = height.length - 1;

        while (left < right) {
            // ���㵱ǰ�����ֵ
            result = Math.max(result, Math.min(height[left], height[right]) * (right - left));
            // ����ұ��߸�
            if (height[left] < height[right]) {
                int k = left;
                // ��[left, right - 1]�У����������ң��ҵ�һ���߶ȱ�height[left]�ߵ�λ��
                while (k < right && height[k] <= height[left]) {
                    k++;
                }

                // ��[left, right - 1]�У���¼��һ����ԭ��height[left]�ߵ�λ��
                left = k;
            }
            // ��ߵ��߸�
            else {
                int k = right;
                // ��[left + 1, right]�У����������ң��ҵ�һ���߶ȱ�height[right]�ߵ�λ��
                while (k > left && height[k] <= height[right]) {
                    k--;
                }

                // ��[left, right - 1]�У���¼��һ����ԭ��height[right]�ߵ�λ��
                right = k;
            }
        }

        return result;
    }
}
