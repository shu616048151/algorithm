import java.util.LinkedList;
import java.util.List;

/**
 * Author: ������
 * Date: 2015-08-21
 * Time: 16:23
 * Declaration: All Rights Reserved !!!
 */
public class Solution {

    private String[] map = {
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz",
    };
    private List<String> result;    // �洢���ս��
    private char[] chars;           // ����ȥ��0��1�ַ��Ľ��
    private char[] curResult;       // �洢�м���
    private int end = 0;            // �ַ������еĵ�һ��δʹ�õ�λ��
    private int handle = 0;         // ��ǰ������ǵڼ����ַ�����

    /**
     * <pre>
     * ԭ��
     * Given a digit string, return all possible letter combinations that the number could represent.
     * A mapping of digit to letters (just like on the telephone buttons) is given below.
     *
     * Input:Digit string "23"
     * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     *
     * Note: Although the above answer is in lexicographical order, your answer
     * could be in any order you want.
     *
     * ��Ŀ����
     * ����һ�����ִ������������������ַ���������ϣ����ֵ��ַ���ӳ������ͼ��ʾ��
     * ע�⣺ ��������Ľ�����ַ�˳�����еģ���������κ�˳�򷵻ؽ����
     *
     * ����˼·
     * ��һ�����鱣�����ֺ��ֵ�ӳ���ϵ���������ִ������룬�ҵ���Ӧ���ַ�����Ͻ����
     * </pre>
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        result = new LinkedList<>();

        if (digits != null && digits.length() > 0) {

            chars = digits.toCharArray();

            // ���ַ������д���ȥ��0��1
            // �ҵ�һ��0����1��λ��
            while (end < digits.length() && chars[end] != '0' && chars[end] != '1') {
                end++;
            }

            handle = end + 1;
            while (handle < chars.length) {
                if (chars[handle] != '0' && chars[handle] != '1') {
                    chars[end] = chars[handle];
                    end++;
                }
                handle++;
            }

            curResult = new char[end];
            // while������endΪ��Ч�ַ��ĳ���
            handle = 0; // ָ���һ����Ч�ַ���λ��

            letterCombinations();
        }
        return result;
    }

    private void letterCombinations() {
        if (handle >= end) {
            result.add(new String(curResult));
        } else {
            int num = chars[handle] - '2';
            for (int i = 0; i < map[num].length(); i++) {
                curResult[handle] = map[num].charAt(i);
                handle++;
                letterCombinations();
                handle--;
            }
        }
    }
}
