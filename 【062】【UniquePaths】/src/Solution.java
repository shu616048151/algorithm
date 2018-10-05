/**
 * Author: ������
 * Date: 2015-08-21
 * Time: 19:30
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * ԭ��
     * A robot is located at the top-left corner of a m x n grid
     * (marked ��Start�� in the diagram below).
     * The robot can only move either down or right at any point in time.
     * The robot is trying to reach the bottom-right corner of the grid
     * (marked ��Finish�� in the diagram below).
     * How many possible unique paths are there?
     *
     * Above is a 3 x 7 grid. How many possible unique paths are there?
     * Note: m and n will be at most 100.
     *
     * ��Ŀ����
     * һ����������һ��m*n�ķ�������Ͻǡ�
     * ������ֻ�����һ�������һ�����񣬻�����Ҫ�������½ǵķ���
     * ����һ���ж�����Ψһ��·����
     * ע�⣺��ͣ���󲻳�100��
     *
     * ����˼·
     * ���͵Ķ�̬�滮���⣬������ʹ�ö�̬�滮�ķ���������⡣
     * ��һ����*n������A��������
     * ����A�����е�Ԫ���С�
     * 1����x=0����y=0ʱ��A[x][y] = 1��
     * 2����x>=1����y>=1ʱ��A[\x][\y] = A[x-1][y]+A[\x][y-1]��
     * 3������Ľ�����A[m-1][n-1]��
     * </pre>
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] result = new int[m][n];

        // ��һ�еĽ�
        for (int i = 0; i < m; i++) {
            result[i][0] = 1;
        }

        // ��һ�еĽ�
        for (int i = 1; i < n; i++) {
            result[0][i] = 1;
        }

        // ����λ�õĽ�
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                result[i][j] = result[i - 1][j] + result[i][j - 1];
            }
        }

        // ����Ľ�
        return result[m - 1][n - 1];
    }
}
