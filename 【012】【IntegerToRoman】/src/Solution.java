/**
 * Author: ������
 * Date: 2015-06-30
 * Time: 14:28
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Given an integer, convert it to a roman numeral.
     *
     * Input is guaranteed to be within the range from 1 to 3999.
     *
     * �������ֵı�ʾ��
     * ��λ������
     * (I, 1)  (II, 2)  (III, 3)  (IV, 4)  (V, 5)  (VI, 6)  (VII, 7)  (VIII, 8)  (IX, 9)
     *
     * ʮλ������
     * (X, 10)  (XI, 11)  (XII, 12)  (XIII, 13)  (XIV, 14)  (XV, 15)  (XVI, 16)
     * (XVII, 17)  (XVIII, 18)  (XIX, 19)  (XX, 20)  (XXI, 21)  (XXII, 22)
     * (XXIX, 29)  (XXX, 30)  (XXXIV, 34)  (XXXV, 35)  (XXXIX, 39)  (XL, 40)
     * (L, 50)  (LI, 51)  (LV, 55)  (LX, 60)  (LXV, 65)  (LXXX, 80)  (XC, 90)
     * (XCIII, 93)  (XCV, 95)  (XCVIII, 98)  (XCIX, 99)
     *
     * ��λ������
     * (C, 100)  (CC, 200)  (CCC, 300)  (CD, 400)  (D, 500)  (DC, 600)  (DCC, 700)
     * (DCCC, 800)  (CM, 900)  (CMXCIX, 999)
     *
     * ǧλ������
     * (M, 1000)  (MC, 1100)  (MCD, 1400)  (MD, 1500)  (MDC, 1600)  (MDCLXVI, 1666)
     * (MDCCCLXXXVIII, 1888)  (MDCCCXCIX, 1899)  (MCM, 1900)  (MCMLXXVI, 1976)
     * (MCMLXXXIV, 1984)  (MCMXC, 1990)  (MM, 2000)  (MMMCMXCIX, 3999)
     *
     * ��Ŀ���⣺
     * ����һ�����֣�����ת��һ���������֣������������[1, 3999]֮��
     *
     * </pre>
     *
     * @param num
     * @return
     */
    public String intToRoman(int num) {

        String[][] base = new String[][]{
                {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}, // ��λ�ı�ʾ
                {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"}, // ʮλ�ı�ʾ
                {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}, // �ٱ��ı�ʾ
                {"M", "MM", "MMM", "", "", "", "", "", ""}}; // ǧλ�ı�ʾ


        String result = "";

        // ÿ��һ�ξ�ʾ�����һ����λ����С����
        // i��¼��ǰ������ǵڼ�����λ
        for (int i = 0; num != 0; num /= 10, i++) {
            // �����Ϊ0��˵�������λ����ֵ��Ҫ������Ӳ���
            if (num % 10 != 0) {
                // ƴ�ӽ��
                result = base[i][num % 10 - 1] + result;
            }
        }

        return result;
    }
}
