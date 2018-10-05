/**
 * Author: ������
 * Date: 2015-07-25
 * Time: 09:27
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        // ��һ�б����õı�־
        boolean rowFlag = false;
        // ��һ�б����õı�־
        boolean colFlag = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    // ��ǵ�һ��Ҫ������
                    if (i == 0) {
                        rowFlag = true;
                    }

                    // ��ǵ�һ��Ҫ������
                    if (j == 0){
                        colFlag = true;
                    }

                    // �������ڱ��Ҫ����Ϊ0���к���
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // �Եڶ��еڶ��п�ʼ��Ԫ������0
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // ���õ�һ��Ϊ0
        if (rowFlag) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        // ���õ�һ��Ϊ0
        if (colFlag) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

    }
}
