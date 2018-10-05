/**
 * Author: ������
 * Date: 2015-08-21
 * Time: 16:47
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * ԭ��
     * The count-and-say sequence is the sequence of integers beginning as follows:
     * 1, 11, 21, 1211, 111221, ...
     * 1 is read off as "one 1" or 11.
     * 11 is read off as "two 1s" or 21.
     * 21 is read off as "one 2, then one 1" or 1211.
     * Given an integer n, generate the nth sequence.
     * Note: The sequence of integers will be represented as a string.
     *
     * ��Ŀ����
     * n=1ʱ����ַ���1��n=2ʱ�����ϴ��ַ����е���ֵ��������Ϊ�ϴ��ַ�����1��1��
     * �������11��n=3ʱ�������ϴ��ַ���11����2��1���������21��n=4ʱ�������ϴ��ַ�����21��
     * ��1��2��1��1���������1211���������ƣ�д��countAndSay(n)���������ַ�����
     *
     * ����˼·
     * ��һ�������n<0ʱ����null��
     * �ڶ����������n=1ʱ������1
     * �������������n>1ʱ������n-1���ص��ַ�����s����s�Ĵ����д������Բ�ͬ������
     * ���з������112365477899���ֳ�11��2��3��6��5��4��77��8��99�����о�2��1��
     * 1��2��1��3��1��6��1��5��һ��4��2��7��1��8��2��9������211213161614271829�����ش˽����
     * </pre>
     *
     * @param n
     * @return
     */
    public String countAndSay(int n) {

        if (n < 1) {
            return null;
        }

        String result = "1";
        for (int i = 2; i <= n; i++) {
            result = countAndSay(result);
        }

        return result;
    }

    public String countAndSay(String str) {
        StringBuilder builder = new StringBuilder(128);

        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                builder.append(count);
                builder.append(str.charAt(i - 1));
                count = 1;
            }
        }

        builder.append(count);
        builder.append(str.charAt(str.length() - 1));
        return builder.toString();
    }
}
