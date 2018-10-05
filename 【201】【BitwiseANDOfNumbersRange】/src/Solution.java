/**
 * Author: ������
 * Date: 2015-06-20
 * Time: 08:56
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND
     * of all numbers in this range, inclusive.
     *
     * For example, given the range [5, 7], you should return 4.
     *
     * ��Ŀ���⣺
     * ��һ����Χ�����������Χ�����е�����λ�������Ľ����
     *
     * ����˼·��
     * ��m!=n����ô��ĩλ�ض���0����Ϊ[m, n]�ض�������ż����������ĩλ��0�����Խ�m��n������һλ��
     * ��Ϊmk�� nk���������൱�ڽ�[m, n]֮������е��������ƶ���һλ����mk=nk��ʱ��˵��֮ǰ
     * [m, n]֮���������һλ������ȵģ����ƺ������AND�������������m(=n)�����Բ����Ϳ���ֹͣ��
     * ��¼���ƵĴ�����offset��m>>offset��Ϊ������
     * </pre>
     *
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd(int m, int n) {
        int offset = 0;

        while (m != n) {
            m >>= 1;
            n >>= 1;
            offset++;
        }

        return m << offset;
    }
}
