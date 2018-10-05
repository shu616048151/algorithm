/**
 * Author: ������
 * Date: 2015-06-17
 * Time: 21:24
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Given a string S, find the longest palindromic substring in S.
     * You may assume that the maximum length of S is 1000, and there
     * exists one unique longest palindromic substring.
     *
     * ��Ŀ���⣺
     * ����һ���ַ���S���ҳ��������Ļ����Ӵ�������Լ����ַ�������󳤶���1000��
     * ���Ҵ���Ψһ��������Ӵ�
     *
     * ����˼·��
     * ��̬�滮����
     * ����dp[ i ][ j ]��ֵΪtrue����ʾ�ַ���s���±�� i �� j ���ַ���ɵ��Ӵ��ǻ��Ĵ�����ô�����Ƴ���
     * dp[ i ][ j ] = dp[ i + 1][ j - 1] && s[ i ] == s[ j ]��
     * ����һ��������������Ҫ����i+1, j -1�������п��� i + 1 = j -1, i +1 = (j - 1) -1�������
     * Ҫ�����׼��������������ϵĹ�ʽ��
     *
     * a. i + 1 = j -1�������ĳ���Ϊ1ʱ��dp[ i ][ i ] = true;
     * b. i +1 = (j - 1) -1�������ĳ���Ϊ2ʱ��dp[ i ][ i + 1] = ��s[ i ] == s[ i + 1]����
     *
     * �������Ϸ����Ϳ���д�������ˡ���Ҫע����Ƕ�̬�滮��Ҫ�����O(n^2)�Ŀռ䡣
     * </pre>
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {

        if (s == null || s.length() < 2) {
            return s;
        }

        int maxLength = 0;
        String longest = null;

        int length = s.length();
        boolean[][] table = new boolean[length][length];

        // �����ַ����ǻ���
        for (int i = 0; i < length; i++) {
            table[i][i] = true;
            longest = s.substring(i, i + 1);
            maxLength = 1;
        }

        // �ж������ַ��Ƿ��ǻ���
        for (int i = 0; i < length - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                table[i][i + 1] = true;
                longest = s.substring(i, i + 2);
                maxLength = 2;
            }
        }


        // �󳤶ȴ���2���Ӵ��Ƿ��ǻ��Ĵ�
        for (int len = 3; len <= length; len++) {
            for (int i = 0, j; (j = i + len - 1) <= length - 1; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    table[i][j] = table[i + 1][j - 1];
                    if (table[i][j] && maxLength < len) {
                        longest = s.substring(i, j + 1);
                        maxLength = len;
                    }
                } else {
                    table[i][j] = false;
                }
            }
        }

        return longest;
    }


}
