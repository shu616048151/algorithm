/**
 * Author: ������
 * Date: 2015-08-21
 * Time: 19:27
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * ԭ��
     * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
     * return the length of last word in the string.
     * If the last word does not exist, return 0.
     * Note: A word is defined as a character sequence consists of non-space characters only.
     * For example,
     * Given s = "Hello World",
     * return 5.
     *
     * ��Ŀ����
     * ����һ���ɴ�Сд��ĸ��Ϳո���ɵ��ַ����������ַ����е����һ�����ʳ��ȡ�
     *
     * ����˼·
     * �ȴӺ��ҵ�һ����ĸ��λ��x�����û���ҵ��ͷ���0������ҵ������ҵ�һ���ո��λ��Ϊy(y������-1��
     * ��Ϊû���ҵ��ո�)�����ؽ��x-y��
     * </pre>
     *
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {

        int index = s.length() - 1;

        // �Ӻ�����ǰ�ҵ�һ������' '���ַ�
        while (index >= 0 && s.charAt(index) == ' ') {
            index--;
        }

        if (index < 0) {
            return 0;
        }

        int tmp = index;

        // ִ�е�����˵���������һ������

        // �Ӻ�����ǰ�ҵ�һ����' '���ַ�
        while (index >= 0 && s.charAt(index) != ' ') {
            index--;
        }

        return tmp - index;
    }
}
