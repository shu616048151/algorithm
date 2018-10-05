import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Author: ������
 * Date: 2015-06-21
 * Time: 08:13
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     *
     * Given a string s and a dictionary of words dict, determine if s can
     * be segmented into a space-separated sequence of one or more dictionary words.
     *
     * For example, given
     * s = "leetcode",
     * dict = ["leet", "code"].
     * Return true because "leetcode" can be segmented as "leet code".
     *
     * ��Ŀ���⣺
     * ����һ���ַ���s�͵����ֵ�dict��ȷ��s�Ƿ���Էָ��һ���������ʿո�ָ������С�
     *
     * ����˼·��
     * һ���ַ���S�����ĳ���ΪN�����S�ܹ������ֵ伯�ϡ���dict���еĵ���ƴ�Ӷ��ɣ���ô��Ҫ���������Ϊ��
     * F(0, N) = F(0, i) && F(i, j) && F(j, N);
     * �����ӣ����������֪��ĳ���Ӵ��Ƿ����Dict�еļ�������ƴ�Ӷ��ɾͿ����������ķ�ʽ�õ����
     * ����������ΪTrue, ����������ΪFalse�����뵽һ��boolean����Ķ�Ӧλ���ϣ������ӣ����boolean
     * ��������һλ����F(0, N)��ֵ��ΪTrue��ʾ����ַ���S����Dict�еĵ���ƴ�ӣ������У�
     * </pre>
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, Set<String> wordDict) {
        // ����У��
        if (s == null || s.length() < 1 || wordDict == null || wordDict.size() < 1) {
            return false;
        }

        // ����Ƿ�ƥ�䣬match[i]���[0, i-1]��ƥ��
        int length = s.length();
        boolean[] match = new boolean[length + 1];
        match[0] = true;

        for (int i = 1; i < length + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (match[j] && wordDict.contains(s.substring(j, i))) {
                    // f(0,n) = f(0,i) + f(i,j) + f(j,n)
                    match[i] = true;
                    break;
                }
            }
        }


        return match[length];
    }


    // ��������һ�ֽⷨ�����ǻᳬʱ
    public boolean wordBreak2(String s, Set<String> wordDict) {

        // ����У��
        if (s == null || s.length() < 1 || wordDict == null || wordDict.size() < 1) {
            return false;
        }

        Map<Character, Set<String>> wordMap = new HashMap<>(wordDict.size());
        // �����п�ʼ�ַ���ͬ�ĵ��ʷ���һ��Set��
        for (String word : wordDict) {
            Set<String> set = wordMap.get(word.charAt(0));
            if (set == null) {
                // �´���һ��set����Map��
                set = new HashSet<>();
                wordMap.put(word.charAt(0), set);
            }
            // ���ʴ���set��
            set.add(word);
        }

        return wordBreak(s, 0, wordMap);
    }

    /**
     * �����ַ����Ƿ���Ա��ָ�ɵ��ʴ�
     *
     * @param s       �ַ���
     * @param idx     ����Ŀ�ʼλ��
     * @param wordMap �����ֵ䣬��ʼ�ַ���ͬ����ͬһ��set������
     * @return �������
     */
    public boolean wordBreak(String s, int idx, Map<Character, Set<String>> wordMap) {

        if (idx >= s.length()) {
            return true;
        }

        Set<String> words = wordMap.get(s.charAt(idx));

        if (words != null) {
            for (String word : words) {
                // idx֮ǰ���ַ��Ѿ�ƥ�䣬�����ide֮����ƥ��word����
                if (s.startsWith(word, idx)) {
                    // �ݹ鴦��
                    boolean result = wordBreak(s, idx + word.length(), wordMap);
                    // �����������������true
                    if (result) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
