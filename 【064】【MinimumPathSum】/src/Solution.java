/**
 * Author: ������
 * Date: 2015-06-22
 * Time: 15:59
 * Declaration: All Rights Reserved !!!
 */
public class Solution {

    /**
     * <pre>
     * Given a m x n grid filled with non-negative numbers, find a path from top
     * left to bottom right which minimizes the sum of all numbers along its path.
     *
     * Note: You can only move either down or right at any point in time.
     *
     * ��Ŀ���⣺
     * ����һ��m x n�ķ���ÿ��Ԫ�ص�ֵ���ǷǸ��ģ��ҳ������ϽǶ��㣬�����½Ƕ���͵�ֵ��С��·����
     * �����ҵ�����С��
     *
     * ע�⣺
     *   - ÿ��ֻ�����»�ȡ�����ƶ�һ������
     *
     * Կ��˼·��
     * ���η���
     * ��һ����  S[0][0] = grid[0][0]
     * ��һ�У�  S[0][j] = S[0][j - 1] + grid[0][j]
     * ��һ�У�  S[i][0] = S[i - 1][0] + grid[i][0]
     * ���������S[i][j] = min(S[i - 1][j], S[i][j - 1]) + grid[i][j]
     * </pre>
     *
     * @param grid
     * @return
     */

    public int minPathSum(int[][] grid) {
        // ��������
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return 0;
        }


        int[][] result = new int[grid.length][grid[0].length];
        // ��һ��
        result[0][0] = grid[0][0];

        // ��һ��
        for (int i = 1; i < result[0].length; i++) {
            result[0][i] = result[0][i - 1] + grid[0][i];
        }

        // ��һ��
        for (int i = 1; i < result.length; i++) {
            result[i][0] = result[i - 1][0] + grid[i][0];
        }

        // �������
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                result[i][j] = Math.min(result[i - 1][j], result[i][j - 1]) + grid[i][j];
            }
        }

        return result[result.length - 1][result[0].length - 1];
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // ��̬�黮�ͷ�֦�޽磬����ķ����ᳬʱ
    ////////////////////////////////////////////////////////////////////////////////////////////////
    public int minPathSum2(int[][] grid) {
        // ��������
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return 0;
        }

        // ���ڼ�¼��С��·����
        int[] minSum = {Integer.MAX_VALUE};
        int[] curSum = {0};
        // ����
        solve(grid, 0, 0, curSum, minSum);

        // ���ؽ��
        return minSum[0];
    }

    public void solve(int[][] grid, int row, int col, int[] curSum, int[] minSum) {
        // ����Ѿ������յ�
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            curSum[0] += grid[row][col];

            // ������С�ĺ�
            if (curSum[0] < minSum[0]) {
                minSum[0] = curSum[0];
            }

            curSum[0] -= grid[row][col];
        }
        // ��δ�����յ㣬������������
        else if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length) {
            curSum[0] += grid[row][col];
            // ��ǰ�ĺ�ֻ�в�С�ڼ�¼������С·��ֵ���ܽ�����һ������
            if (curSum[0] <= minSum[0]) {
                // ������
                solve(grid, row, col + 1, curSum, minSum);
                // ������
                solve(grid, row + 1, col, curSum, minSum);
            }
            curSum[0] -= grid[row][col];
        }
    }
}
