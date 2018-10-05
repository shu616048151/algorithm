/**
 * Author: ������
 * Date: 2015-06-22
 * Time: 15:42
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * Say you have an array for which the ith element is the price of a given stock on day i.
     *
     * If you were only permitted to complete at most one transaction (ie, buy one and sell
     * one share of the stock), design an algorithm to find the maximum profit.
     *
     * ��Ŀ���⣺
     * ��һ������prices[]��prices[i]�����Ʊ�ڵ�i����ۼۣ����ֻ��һ�ν���(һ�����������)�ܵõ���������档
     *
     * ����˼·��
     * ֻ��Ҫ�ҳ����Ĳ�ֵ���ɣ��� max(prices[j] �C prices[i]) ��i < j��һ�α������ɣ��ڱ�����ʱ���ñ���
     * low��¼ prices[o....i] �е���Сֵ�����ǵ�ǰΪֹ������ۼۣ�ʱ�临�Ӷ�Ϊ O(n)��
     * </pre>
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length < 1) {
            return 0;
        }

        int min = prices[0];
        int profit = 0;

        // ��i��ļ۸���Կ����������Ҳ���Կ�����������
        for (int i = 1; i < prices.length; i++) {
            // �ҵ����͵������
            if (min > prices[i]) {
                // ���������
                min = prices[i];
            }
            // ����ļ۸񲻵��������
            else {
                // �����������ļ۸��֮ǰ�����ļ۸��
                if (profit < prices[i] - min) {
                    // ����������
                    profit = prices[i] - min;
                }
            }
        }

        return profit;
    }
}
