import java.util.LinkedList;
import java.util.List;

/**
 * Author: ������
 * Date: 2015-06-22
 * Time: 08:51
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
     * A region is captured by flipping all 'O's into 'X's in that surrounded region.
     *
     * For example,
     * X X X X
     * X O O X
     * X X O X
     * X O X X
     *
     * After running your function, the board should be:
     * X X X X
     * X X X X
     * X X X X
     * X O X X
     *
     * ��Ŀ���⣺
     * һ����ά��񣬰���'X'��'O'�������Ա�X��Χ��O������X�����������������
     * ����˼·��
     * ���ù�����ȱ����ķ�ʽ����Ҳ���Բ��ó���������ȵķ�ʽ������ջ�������,��ǳ����еı���Χ�ĵ㣬ʣ�µľ��ǲ�����Χ�ĵ�
     * </pre>
     *
     * @param board
     */
    ////////////////////////////////////////////////////////////////////////////////////////////////
    // ������ù�ȶ����ȱ����ķ�ʽ���ҳ����еġ���������Χ�ĵ�
    ////////////////////////////////////////////////////////////////////////////////////////////////
    public void solve(char[][] board) {
        // ����У��
        if (board == null || board.length < 1 || board[0].length < 1) {
            return;
        }

        boolean[][] visited = new boolean[board.length][board[0].length];
        // �����������ʱ��ΧһȦ��Ԫ��
        List<Coordinate> round = new LinkedList<>();
        // ��������
        for (int col = 0; col < board[0].length; col++) {
            // �����У����ҵ���O���ҵ�δ�����ʹ�
            if (!visited[0][col] && board[0][col] == 'O') {
                round.clear();
                round.add(new Coordinate(0, col));
                bfs(board, visited, round);
            }
        }

        // ����ײ���
        for (int col = 0; col < board[0].length; col++) {
            // �����У����ҵ���O���ҵ�δ�����ʹ�
            if (!visited[board.length - 1][col] && board[board.length - 1][col] == 'O') {
                round.clear();
                round.add(new Coordinate(board.length - 1, col));
                bfs(board, visited, round);
            }
        }

        // ���������
        for (int row = 1; row < board.length - 1; row++) {
            // �����У����ҵ���O���ҵ�δ�����ʹ�
            if (!visited[row][0] && board[row][0] == 'O') {
                round.clear();
                round.add(new Coordinate(row, 0));
                bfs(board, visited, round);
            }
        }

        // �����ұ���
        for (int row = 1; row < board.length - 1; row++) {
            // �����У����ҵ���O���ҵ�δ�����ʹ�
            if (!visited[row][board[0].length - 1] && board[row][board[0].length - 1] == 'O') {
                round.clear();
                round.add(new Coordinate(row, board[0].length - 1));
                bfs(board, visited, round);
            }
        }

        // �������
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // ���δ�����ʹ��������ֿ��ܣ���һ��X�㣬�ڶ���O�㣬O��һ���Ǳ�X��Χ��
                // ��ʱ��δ���ʹ��ĵ�����ΪX����ȷ��
                if (!visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    /**
     * ������ȣ��Ҳ�����Χ�ĵ�
     *
     * @param board   ��ά����
     * @param visited ���ʱ������
     * @param round   �����������ʱ��ΧһȦ��Ԫ��
     */
    public void bfs(char[][] board, boolean[][] visited, List<Coordinate> round) {
        Coordinate c;
        while (round.size() > 0) {
            c = round.remove(0);
            if (c.x >= 0 && c.x < board.length && c.y >= 0 && c.y < board[0].length && board[c.x][c.y] == 'O' && !visited[c.x][c.y]) {
                visited[c.x][c.y] = true;
                round.add(new Coordinate(c.x - 1, c.y));
                round.add(new Coordinate(c.x, c.y + 1));
                round.add(new Coordinate(c.x + 1, c.y));
                round.add(new Coordinate(c.x, c.y - 1));
            }
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // ������ù�ȶ����ȱ����ķ�ʽ���ҳ����еı���Χ�ĵ㣬���ұ�ǻᳬʱ
    ////////////////////////////////////////////////////////////////////////////////////////////////
    public void solve2(char[][] board) {
        // ����У��
        if (board == null || board.length < 1 || board[0].length < 1) {
            return;
        }

        boolean[][] visited = new boolean[board.length][board[0].length];

        // �����������ʱ��ΧһȦ��Ԫ��
        List<Coordinate> round = new LinkedList<>();
        // �������������������Ԫ��
        List<Coordinate> all = new LinkedList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!visited[i][j] && board[i][j] == 'O') {
                    // �������������һȦ��Ԫ��
                    round.add(new Coordinate(i, j));
                    boolean result = bfs(board, visited, round, all);
                    // һ������������O���������ڣ����Ҳ��ڱ߽���
                    if (result) {
                        // ���ñ��
                        for (Coordinate c : all) {
                            board[c.x][c.y] = 'X';
                        }
                    }

                    // ���Ԫ��
                    round.clear();
                    all.clear();
                }
            }
        }

    }

    /**
     * ������ȱ���
     *
     * @param board   ��ά����
     * @param visited ���ʱ������
     * @param round   �����������ʱ��ΧһȦ��Ԫ��
     * @param all     �������������������Ԫ��
     * @return true����O�����������ڣ����Ҳ��ڱ߽��ϣ��������X���ܷ���true
     */
    public boolean bfs(char[][] board, boolean[][] visited, List<Coordinate> round, List<Coordinate> all) {
        boolean result = true;
        int size = round.size();
        Coordinate c;
        while (size > 0) {
            size--;

            // ȡ����Ԫ��
            c = round.remove(0);
            // ��ӵ�������¼Ԫ�ؼ�����
            all.add(c);
            // ����Ѿ������ʹ���
            visited[c.x][c.y] = true;
            // �ж�c�Ƿ���O�ڵ�
            result &= isInner(board, c.x, c.y);

            // c������һ�����Ƿ���O������û�з��ʹ����������ӵ�round������
            if (isO(board, c.x - 1, c.y) && !visited[c.x - 1][c.y]) {
                round.add(new Coordinate(c.x - 1, c.y));
            }

            // c������һ�����Ƿ���O������û�з��ʹ����������ӵ�round������
            if (isO(board, c.x, c.y + 1) && !visited[c.x][c.y + 1]) {
                round.add(new Coordinate(c.x, c.y + 1));
            }

            // c������һ�����Ƿ���O������û�з��ʹ����������ӵ�round������
            if (isO(board, c.x + 1, c.y) && !visited[c.x + 1][c.y]) {
                round.add(new Coordinate(c.x + 1, c.y));
            }

            // c������һ�����Ƿ���O������û�з��ʹ����������ӵ�round������
            if (isO(board, c.x, c.y - 1) && !visited[c.x][c.y - 1]) {
                round.add(new Coordinate(c.x, c.y - 1));
            }
        }

        if (round.size() > 0) {
            return bfs(board, visited, round, all) && result;
        } else {
            return result;
        }

    }

    /**
     * �жϵ��ڶ�ά����ڲ������Ҳ��ڱ߽���
     *
     * @param board ��ά����
     * @param x     ������
     * @param y     ������
     * @return true��
     */
    public boolean isInner(char[][] board, int x, int y) {
        return x > 0 && x < board.length - 1 && y > 0 && y < board[0].length - 1;
    }

    /**
     * �жϵ��Ƿ���O
     *
     * @param board ��ά����
     * @param x     ������
     * @param y     ������
     * @return true��
     */
    public boolean isO(char[][] board, int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == 'O';
    }

    /**
     * �������
     */
    public static class Coordinate {
        private int x;
        private int y;

        public Coordinate() {
        }

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }
}
