/**
 * Author: ������
 * Date: 2015-08-21
 * Time: 19:34
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * ԭ��
     * Given two binary strings, return their sum (also a binary string).
     * For example,
     * a = "11"
     * b = "1"
     * Return "100"
     *
     * ��Ŀ����
     * �������������Ƶ��ַ������������ǵĺͣ�Ҳ�Ƕ��������ַ�����
     *
     * ����˼·
     * �Ƚ���Ӧ�������������ַ���ת���ɶ�Ӧ���������飬�ӵ�λ����λ������ӣ�ͬʱҪ���ǵ����
     * ��ӻ�Ҫ��չһλ������������������ʵ�֡�
     * </pre>
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {

        int[] ca = new int[a.length()];
        int[] cb = new int[b.length()];

        // ���ַ������е�ֵת������ֵ��0����1
        for (int i = 0; i < a.length(); i++) {
            ca[i] = a.charAt(i) - '0';
        }

        // ���ַ������е�ֵת������ֵ��0����1
        for (int i = 0; i < b.length(); i++) {
            cb[i] = b.charAt(i) - '0';
        }

        // ʹ��ca����ĳ��ȳ�
        if (ca.length < cb.length) {
            int[] tmp = ca;
            ca = cb;
            cb = tmp;
        }


        int ai = ca.length - 1; // �ַ�����ca���һ�������±�
        int bi = cb.length - 1; // �ַ�����cb���һ�������±�
        int carry = 0; // ��λ�Ľ�λ��ʶ
        int result; // ���صĽ��

        // ������磺1010101101 + 10100
        while (ai >= 0 && bi >= 0) {
            result = ca[ai] + cb[bi] + carry;
            ca[ai] = result % 2;
            carry = result / 2;

            ai--;
            bi--;
        }

        // �������µ�����
        while (ai >= 0) {
            result = ca[ai] + carry;
            ca[ai] = result % 2;
            carry = result / 2;

            if (carry == 0) {
                break;
            }

            ai--;
        }

        // ���ַ������е�ֵת�����ַ���0����1
        for (int i = 0; i < ca.length; i++) {
            ca[i] += '0';
        }

        // ����Ҫ��չһλ
        if (carry == 0) {

            char[] ch = new char[ca.length];
            for (int i = 0; i < ca.length; i++) {
                ch[i] = (char) (ca[i]);
            }

            return new String(ch);
        }
        // ��Ҫ��չһλ
        else {
            char[] ch = new char[ca.length + 1];
            ch[0] = '1';
            for (int i = 0; i < ca.length; i++) {
                ch[i + 1] = (char) (ca[i]);
            }
            return new String(ch);
        }
    }
}
