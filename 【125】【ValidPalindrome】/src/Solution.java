/**
 * Author: ������
 * Date: 2015-08-21
 * Time: 19:10
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * ԭ��
     * Given a string, determine if it is a palindrome, considering only
     * alphanumeric characters and ignoring cases.
     * For example,
     * "A man, a plan, a canal: Panama" is a palindrome.
     * "race a car" is not a palindrome.
     * Note:
     * Have you consider that the string might be empty? This is a good
     * question to ask during an interview.
     * For the purpose of this problem, we define empty string as valid palindrome.
     *
     * ��Ŀ����
     * ����һ���ַ������ж����Ƿ��ǻ����ַ�������������ĸ�����Һ��Դ�Сд��
     *
     * ����˼·
     * ʹ����βָ�룬�ֱ��ҵ���һ������������λ�ã����бȽϣ������Ⱦͽ�����һ��Ƚϣ�
     * ����Ⱦͷ���false��ֱ�����е���ĸ�������ꡣ
     * </pre>
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {

        if (s == null) {
            return false;
        }

        int left = 0;
        int right = s.length() - 1;

        int delta = 'A' - 'a';
        char l;
        char r;

        while (left < right) {
            while (left < s.length() && !isAlphanumericCharacters(s.charAt(left))) { // ������������������ĸ
                left++;
            }

            while (right >= 0 && !isAlphanumericCharacters(s.charAt(right))) { // ������������������ĸ
                right--;
            }

            if (left < right) {
                l = s.charAt(left);
                r = s.charAt(right);
                if (l == r || l - r == delta || r - l == delta) {
                    left++;
                    right--;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * �ж��Ƿ�����ĸ��������
     *
     * @param c ���жϵ�����
     * @return �жϽ��
     */
    private boolean isAlphanumericCharacters(char c) {
        return c >= '0' && c <= '9' || c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }
}
