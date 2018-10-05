/**
 * Author: ������
 * Date: 2015-06-30
 * Time: 20:46
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Divide two integers without using multiplication, division and mod operator.
     * If it is overflow, return MAX_INT.
     *
     * ��Ŀ���⣺
     * ��ʹ�ó������˷���ȡ�࣬����������������Ľ�������������ͷ�����������
     *
     * ����˼·��
     * �κ�һ���������Ա�ʾ����2����Ϊ�׵�һ�����������ϣ�
     * ��num=a_0*2^0+a_1*2^1+a_2*2^2+...+a_n*2^n��
     * �������������ʽ�Լ�����һλ�൱�ڳ���2���������ó�
     * ������ֱ�����ڱ�����֮ǰ�õ�һ�����Ļ���Ȼ�����������
     * ÿ�γ��Լ�ȥ���������������������Ӽ�2^k,Ȼ���������
     * �Ƶ�����ֱ����Ϊ0Ϊֹ����Ϊ��������ĵ��������ǰ�2����֪
     * ���������������ʱ�临�Ӷ�ΪO(log(n))��
     *
     * </pre>
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        // ���ʱ�������
        if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // �����λ
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;

        // �����ֵ��Ϊ��ֹ���ʹ��long
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        // ��¼���
        int result = 0;

        // ���������ڳ���
        while (dvd >= dvs) {
            // ��¼����
            long tmp = dvs;
            // ��¼�̵Ĵ�С
            long mul = 1;

            while (dvd >= (tmp << 1)) {
                tmp <<= 1;
                mul <<= 1;
            }

            // ��ȥ��ӽ�dvd��dvs��ָ������ֵ��ֵΪtmp��
            dvd -= tmp;

            // �������
            result += mul;
        }

        return result * sign;
    }
}
