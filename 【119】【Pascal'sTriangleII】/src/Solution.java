import java.util.ArrayList;
import java.util.List;

/**
 * Author: ������
 * Date: 2015-08-21
 * Time: 19:09
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * ԭ��
     * Given an index k, return the kth row of the Pascal��s triangle.
     * For example, given k = 3,
     * Return [1,3,3,1].
     * Note:
     * Could you optimize your algorithm to use only O(k) extra space?
     *
     * ��Ŀ����
     * ����һ��������k������˹���ĵ�k�С�
     *
     * ����˼·
     * �������n>0��
     * f(1, n)=1��(n>0)
     * f(n, n)=1��(n>2)
     * f(i,j) = f(i-1, j-1)+f(i, j-1)��i>2,j>2��
     * ���k�С�
     * </pre>
     *
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {

        rowIndex++; // ��rowIndex��ʵ��������Ŀ

        if (rowIndex < 0) {
            return null;
        }

        List<Integer> result = new ArrayList<>(rowIndex);

        if (rowIndex >= 1) {
            result.add(1);
        }

        if (rowIndex >= 2) {
            result.add(1);
        }

        int line = 0; // ��¼��ǰʹ����һ��
        int prev; // ��һ������һ��
        if (rowIndex >= 3) {

            int[][] data = new int[2][rowIndex];
            // ��1��
            data[0][0] = 1;
            data[1][0] = 1;
            data[1][1] = 1;

            for (int i = 2; i < rowIndex; i++) {
                line = i % 2; // �¼�������ݱ����ڵ�0���ߵ�1��
                prev = (i - 1 + 2) % 2;
//                data[line][0] = 1; // ���õ�һ�����֣����Բ��ã���1�����Ѿ������ˣ�data[x][0]��Ϊ1
                for (int j = 1; j < i; j++) {
                    data[line][j] = data[prev][j - 1] + data[prev][j];
                }

                data[line][i] = 1; // �������һ����
            }

            //
            result.clear();
            for (int i = 0; i < rowIndex; i++) {
                result.add(data[line][i]);
            }

        }

        return result;
    }
}
