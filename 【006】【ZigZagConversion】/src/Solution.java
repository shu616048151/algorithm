/**
 * Author: ������
 * Date: 2015-08-21
 * Time: 16:08
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     *     ԭ��
     * The string ��PAYPALISHIRING�� is written in a zigzag pattern on a given number
     * of rows like this: (you may want to display this pattern in a fixed font for
     * better legibility)
     * ����P A H N
     * ����APLSIIG
     * ����Y I R
     * And then read line by line: ��PAHNAPLSIIGYIR��
     * Write the code that will take a string and make this conversion given a number of rows:
     * string convert(string text, int nRows);
     * convert(��PAYPALISHIRING��,3) should return ��PAHNAPLSIIGYIR��.
     * ��Ŀ����
     * ����һ���ַ�����ָ�������������ַ���Z���������
     *
     * ����˼·
     * ������ַ������������������������������һ��һά���飬�ټ���ÿ���ַ���һά�����е�λ�ã�
     * �ٶ�һά�����е��ַ����н��ղ��������ؽ����
     * </pre>
     *
     * @param s
     * @param nRows
     * @return
     */

	 
    public  String convert(String s, int nRows) {

        if (s == null || s.length() <= nRows || nRows == 1) {
            return s;
        }

        int index = s.length();
        int rowLength = 0; // �����еĳ��ȣ�����������ַ�

        int slash = nRows - 2; // һ��б�߳�ȥ��β��ռ�õ�����

        while (index > 0) {
            // ���ε�һ��
            index -= nRows;
            rowLength++;

            // б�ŵ�����
            for (int i = 0; i < slash && index > 0; i++) {
                rowLength++;
                index--;
            }
        }

        char[] result = new char[nRows * rowLength]; // �����������飬���һ�����ڱ��滻�з�
        for (int i = 0; i < result.length; i++) { // ��ʼ��Ϊ�ո�
            result[i] = ' ';
        }

        int curColumn = 0; // ��ǰ���������
        index = 0;
        while (index < s.length()) {
            // ��������
            for (int i = 0; i < nRows && index < s.length(); i++) {
                result[rowLength * i + curColumn] = s.charAt(index);
                index++;
            }
            curColumn++;
            // ����б��
            for (int i = nRows - 2; i > 0 && index < s.length(); i--) {
                result[rowLength * i + curColumn] = s.charAt(index);
                curColumn++;
                index++;
            }
        }

        // ���ַ�������н��ղ���
        index = 0;
        while (index < s.length() && result[index] != ' ') { // �ҵ�һ���ǿո���ַ�λ��
            index++;
        }
        int next = index + 1;
        while (index < s.length()) {
            while (next < result.length && result[next] == ' ') { // �Ҳ��ǿո��Ԫ��
                next++;
            }
            result[index] = result[next];
            index++;
            next++;
        }
        return new String(result, 0, index);
    }
}
