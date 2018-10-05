/**
 * Author: ������
 * Date: 2015-08-21
 * Time: 16:59
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * ԭ��
     * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
     * The Sudoku board could be partially filled, where empty cells are filled
     * with the character '.'.
     *
     * A partially filled sudoku which is valid.
     * Note:
     * A valid Sudoku board (partially filled) is not necessarily solvable.
     * Only the filled cells need to be validated.
     *
     * ��Ŀ����
     * ��֤һ�����������Ƿ�Ϸ����������̵���֤��������Ӷ�Ӧ��ҳ�档
     * ���������ǲ��������ģ��յ�λ��ʹ�õ������档
     * ע�⣺�Ϸ������̲�һ��Ҫ��Ŀɽ�ģ�ֻҪ������������Ҫ��Ϳ��ԡ�
     *
     * ����˼·
     * �ȶ��н��м�飬�ٶ��н��м�飬����飳*���ķ���
     * </pre>
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        // .��ASCIIֵ��46��0��ASCIIֵ��48��/��ASCIIֵ��47
        int number = board[0].length;
        int[] record = new int[10 + 2]; //����.��9��ֵ���������ݵ�λ����[2, 10]
        boolean isValid;
        reset(record);

        // ���н��м��
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                record[board[i][j] - '.']++;
            }

            if (!check(record)) { // ���Ǽ��ʧ��
                return false;
            } else { // ���ɹ���������
                reset(record);
            }
        }

        // ���н��м��
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                record[board[j][i] - '.']++;
            }

            if (!check(record)) { // ���Ǽ��ʧ��
                return false;
            } else { // ���ɹ���������
                reset(record);
            }
        }

        // ���3*3����
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                for (int k = i * 3; k < (i + 1) * 3; k++) {
                    for (int l = j * 3; l < (j + 1) * 3; l++) {
                        record[board[k][l] - '.']++;
                    }
                }

                if (!check(record)) { // ���Ǽ��ʧ��
                    return false;
                } else { // ���ɹ���������
                    reset(record);
                }
            }
        }
        return true;
    }

    private void reset(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = 0;
        }


    }

    /**
     * �������һ�У�һ�У�����3*3�ķ����Ƿ�Ϸ������1-9�е����ָ�������1�Ͳ��Ϸ�
     *
     * @param a ��֤����
     * @return ���ؽ��
     */
    private boolean check(int[] a) {
        for (int i = 2; i < a.length; i++) {
            if (a[i] > 1) {
                return false;
            }
        }
        return true;
    }
}
