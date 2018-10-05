/**
 * Author: ������
 * Date: 2015-06-20
 * Time: 09:28
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Given an input string, reverse the string word by word.
     *
     * For example,
     * Given s = "the sky is blue",
     * return "blue is sky the".
     *
     * ��Ŀ���⣺
     * ����һ���ַ��������䷴ת������ִʲ�ת
     *
     * ����˼·��
     * �ȶ������ַ�����ת���ٽ�ÿ�����ʽ��з�ת
     * </pre>
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {

        if (s == null) {
            return null;
        }

        char[] chars = s.toCharArray();
        // �ַ�ѹ��
        int realLength = compressWhiteSpace(chars);

        // ���������ַ���
        swapRange(chars, 0, realLength - 1);

        // ��¼���ʵ����
        int start = 0;
        // ��¼���ʵ��յ�
        int end;

        while (start < realLength) {
            // ��startλ�ÿ�ʼ�ҵ�һ���ǿհ��ַ�
            while (start < realLength && chars[start] == ' ') {
                start++;
            }

            end = start + 1;
            // �ҵ�һ���հ��ַ�
            while (end < realLength && chars[end] != ' ') {
                end++;
            }

            // ��ת�ַ�
            swapRange(chars, start, end - 1);
            // ��¼�µĿ�ʼλ��
            start = end;
        }
        return new String(chars, 0, realLength);
    }

    /**
     * ���ַ�����ĵĿհ��ַ�����ѹ��
     *
     * @param chars �ַ�����
     * @return �µĳ���
     */
    public int compressWhiteSpace(char[] chars) {

        if (chars == null || chars.length == 0) {
            return 0;
        }

        // �����ַ���λ��
        int pos = 0;
        for (int i = 0; i < chars.length; i++) {
            // ��iλ�ÿ�ʼ�ҵ�һ���ǿհ��ַ�
            while (i < chars.length && chars[i] == ' ') {
                i++;
            }

            // �Ѿ���������
            if (i >= chars.length) {
                break;
            }

            // ��iλ�ÿ�ʼ����ǿհ��ַ���ֱ�������հ��ַ�
            // ���Ǵ���һ������
            while (i < chars.length && chars[i] != ' ') {
                chars[pos] = chars[i];
                pos++;
                i++;
            }

            // ������һ������Ҫ��һ�����һ�����ʲ��ж��һ��A��
            if (pos < chars.length) {
                // ���ո�
                chars[pos] = ' ';
            }

            pos++;
        }

        // ˵���ַ�����ֻ�пհ��ַ�
        if (pos == 0) {
            return 0;
        } else {
            // ��һ����Ҫȥ�������һ���ո񣬼���A��
            return pos - 1;
        }

    }

    /**
     * ��ת������������[x, y]λ�õ��ַ�
     *
     * @param chars �ַ�����
     * @param x     xλ��
     * @param y     yλ��
     */
    public void swapRange(char[] chars, int x, int y) {
        for (; x < y; x++, y--) {
            swap(chars, x, y);
        }
    }

    /**
     * ����������x,y����λ�õĵ���
     *
     * @param chars �ַ�����
     * @param x     xλ��
     * @param y     yλ��
     */
    public void swap(char[] chars, int x, int y) {
        char z = chars[x];
        chars[x] = chars[y];
        chars[y] = z;
    }
}
