/**
 * Author: ������
 * Date: 2015-06-20
 * Time: 07:19
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Given a 2D board and a word, find if the word exists in the grid.
     *
     * The word can be constructed from letters of sequentially adjacent cell,
     * where "adjacent" cells are those horizontally or vertically neighboring.
     * The same letter cell may not be used more than once.
     *
     * For example,
     * Given board =
     * [
     *      ["ABCE"],
     *      ["SFCS"],
     *      ["ADEE"]
     * ]
     * word = "ABCCED", -> returns true,
     * word = "SEE", -> returns true,
     * word = "ABCB", -> returns false.
     *
     * ��Ŀ���⣺
     * ����һ��board�ַ����󣬿��Դ�����һ���㿪ʼ�����������ҵķ�ʽ�ߣ�ÿ����ֻ����һ�Σ�
     * �������һ��·�߹����ַ����ڸ������ַ�������ô����true
     *
     * ����˼·��
     * ��ÿһ������Ϊ��㣬ʹ�û��ݷ���������
     * </pre>
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        // ��ע�����Ǽٶ�����Ĳ������ǺϷ���

        // ���ʱ�Ǿ��󣬳�ʼֵĬ�ϻ�����Ϊfalse
        boolean[][] visited = new boolean[board.length][board[0].length];

        // ��ÿһ��λ��Ϊ�������������ҵ�һ��·����ֹͣ
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (search(board, visited, i, j, word, new int[]{0})) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * @param board   �ַ�����
     * @param visited ���ʱ�Ǿ���
     * @param row     ���ʵ��к�
     * @param col     ���ʵ��к�
     * @param word    ƥ����ַ���
     * @param idx     ƥ���λ�ã�ȡ�����Ǹ��º��ֵ���Ա�������������
     * @return
     */
    private boolean search(char[][] board, boolean[][] visited, int row, int col, String word, int[] idx) {
        // ���������λ�õ����ִ��ĳ��ȣ�˵���Ѿ��ҵ��ҵ�ƥ�����
        if (idx[0] == word.length()) {
            return true;
        }

        boolean hasPath = false;
        // ��ǰλ�úϷ�
        if (check(board, visited, row, col, word, idx[0])) {
            // ���λ�ñ����ʹ�
            visited[row][col] = true;
            idx[0]++;
            // ���ϣ��ң��£����ĸ������������
            hasPath = search(board, visited, row - 1, col, word, idx ) // ��
                    || search(board, visited, row, col + 1, word, idx) // ��
                    || search(board, visited, row + 1, col, word, idx) // ��
                    || search(board, visited, row, col - 1, word, idx); // ��


            // ���û���ҵ�·���ͻ���
            if (!hasPath) {
                visited[row][col] = false;
                idx[0]--;
            }
        }

        return hasPath;
    }

    /**
     * �ж����ʵ�λ���Ƿ�Ϸ�
     *
     * @param board   �ַ�����
     * @param visited ���ʱ�Ǿ���
     * @param row     ���ʵ��к�
     * @param col     ���ʵ��к�
     * @param word    ƥ����ַ���
     * @param idx     ƥ���λ��
     * @return
     */

    public boolean check(char[][] board, boolean[][] visited, int row, int col, String word, int idx) {
        return row >= 0 && row < board.length // �кźϷ�
                && col >= 0 && col < board[0].length // �кźϷ�
                && !visited[row][col] // û�б����ʹ�
                && board[row][col] == word.charAt(idx); // �ַ����
    }
}
