import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Author: ������
 * Date: 2015-06-19
 * Time: 11:57
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * Given two strings s and t, determine if they are isomorphic.
     * <p>
     * Two strings are isomorphic if the characters in s can be replaced to get t.
     * <p>
     * All occurrences of a character must be replaced with another character while
     * preserving the order of characters. No two characters may map to the same character
     * but a character may map to itself.
     * <p>
     * For example,
     * Given "egg", "add", return true.
     * Given "foo", "bar", return false.
     * Given "paper", "title", return true.
     * <p>
     * Note:
     * You may assume both s and t have the same length.
     * <p>
     * ��Ŀ���⣺
     * ���������ַ���s��t���ж������Ƿ���ͬ���ġ�
     * <p>
     * ����ַ���s����ͨ���ַ��滻�ķ�ʽ�õ��ַ���t�����s��t��ͬ���ġ�
     * <p>
     * �ַ���ÿһ�γ��ֶ����뱻���Ӧ�ַ����滻��ͬʱ����Ҫ��֤ԭʼ˳�򲻷����ı䡣
     * �����ַ�����ӳ�䵽ͬһ���ַ��������ַ�����ӳ�䵽�䱾��
     * <p>
     * ������������Ŀ������
     * ���Լ���s��t�ȳ���
     * <p>
     * ����˼·��
     * ��ֻҪs��t����һһӳ��Ϳ����ˡ�
     * ʹ��һ����ϣ��mapά�������ַ������ַ���ӳ���ϵ��ͬʱ��һ��set����ӳ���ֵ��
     * (s[i], t[i])������s[i]��û����map�г��ֹ�����t[i]û����set�г��ֹ����ͼ��뵽ӳ���ϵ�У�
     * t[i]ֵ�Ѿ����ֹ���˵���Ƕ��һӳ�䣬�����Ϸ���false��s[i]������Ѿ����ֹ���
     * ��Ϊs[k]����Ӧ��ӳ��ֵΪt[k]),��s[i]==s[k],���ҳ�s[k]�ĶԶ�Ӧֵt[k]��
     * ���t[i]!=t[k],˵��һ��ͬһ���ַ�����������ͬ��ӳ�䣬�����ַ�������ͬ���ģ�����false��
     * ����������һ���ַ���ֱ������
     * <p>
     * ������ӳ�䲻һ�µ�����ʱ������False�����򷵻�True
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {

        // �����ַ�����Ϊ��
        if (s == null && t == null) {
            return true;
        }
        // ֻ��һ��Ϊ��
        else if (s == null || t == null) {
            return false;
        }
        // �����ַ����ĳ��ȶ�Ϊ0
        else if (s.length() == 0 && t.length() == 0) {
            return true;
        }
        // �����ַ����ĳ��Ȳ����
        else if (s.length() != t.length()) {
            return false;
        }

        // ����ӳ���ϵ
        Map<Character, Character> map = new HashMap<>(s.length());
        Set<Character> set = new HashSet<>(t.length());
        char sChar;
        char tChar;
        for (int i = 0; i < s.length(); i++) {
            sChar = s.charAt(i);
            tChar = t.charAt(i);

            // ��δ���ֹ����Ͱ���ӳ���ϵ
            if (!map.containsKey(sChar)) {
                if (set.contains(tChar)) {
                    return false;
                } else {
                    map.put(s.charAt(i), t.charAt(i));
                    set.add(tChar);
                }
            }
            // ���Ǽ��Ѿ����ֹ�
            else {

                // ԭ�ȵļ�ӳ���ֵ��map.get(sChar)������Ҫӳ���ֵ��tChar
                // �������ֵ����ȣ�˵���Ѿ�ӳ�������Σ������ϣ�����false
                if (map.get(sChar) != tChar) {
                    return false;
                }
            }


        }


        return true;
    }
}
