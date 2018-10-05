/**
 * Author: ������
 * Date: 2015-06-22
 * Time: 21:38
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Follow up for "Unique Paths":
     * Now consider if some obstacles are added to the grids. How many unique paths would there be?
     * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
     *
     * For example,
     * There is one obstacle in the middle of a 3x3 grid as illustrated below.
     * [
     *      [0,0,0],
     *      [0,1,0],
     *      [0,0,0]
     * ]
     *
     * The total number of unique paths is 2.
     * Note: m and n will be at most 100.
     *
     * ��Ŀ���⣺
     * Ψһ·��������������·�������ϰ������ܵ�·��������
     * ע�⣺
     * �����������������������100
     *
     * ����˼·��
     * ���÷�����ⷽ��
     *
     * </pre>
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // ����У��
        if (obstacleGrid == null || obstacleGrid.length < 1 || obstacleGrid[0].length < 1
                || obstacleGrid[0][0] == 1
                || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
            return 0;
        }

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[][] result = new int[rows][cols];

        // ��һ��λ���ж����ַ��������ϰ�����1�֣����ϰ�����0��
        result[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;

        // ��һ���ж������߷������ϰ�����0
        for (int i = 1; i < cols; i++) {
            result[0][i] = obstacleGrid[0][i] == 0 ? result[0][i - 1] : 0;
        }

        // ��һ���ж������߷������ϰ�����0
        for (int i = 1; i < rows; i++) {
            result[i][0] = obstacleGrid[i][0] == 0 ? result[i - 1][0] : 0;
        }

        // ����λ�õĽⷨ�����ϰ�����0
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                result[i][j] = obstacleGrid[i][j] == 0 ? result[i - 1][j] + result[i][j - 1] : 0;
            }
        }

        return result[rows - 1][cols - 1];
    }


    // ʹ�õݹ鷽���ᳬʱ
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        // ����У��
        if (obstacleGrid == null || obstacleGrid.length < 1 || obstacleGrid[0].length < 1
                || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
            return 0;
        }
        int[] result = {0};
        solve(obstacleGrid, 0, 0, result);
        return result[0];
    }

    public void solve(int[][] grid, int row, int col, int[] sum) {
        // �����յ�
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            sum[0]++;
        }
        // û�е��յ㣬���������ڣ����ҵ�ǰλ�ò���
        else if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 0) {
            // ������
            solve(grid, row, col + 1, sum);
            // ������
            solve(grid, row + 1, col, sum);
        }
    }
}
