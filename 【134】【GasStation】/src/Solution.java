/**
 * Author: ������
 * Date: 2015-06-21
 * Time: 10:11
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * There are N gas stations along a circular route, where the amount
     * of gas at station i is gas[i].
     *
     * You have a car with an unlimited gas tank and it costs cost[i] of gas
     * to travel from station i to its next station (i+1). You begin the journey
     * with an empty tank at one of the gas stations.
     *
     * Return the starting gas station's index if you can travel around the
     * circuit once, otherwise return -1.
     *
     * Note:
     *   - The solution is guaranteed to be unique.
     *
     * ��Ŀ���⣺
     * �ػ���·����N������վ�����������ڳ�վi������gas[i]��
     * ���г����������������ޣ��Ӽ���վi����һ������վվ��i+1��Ҫ����cost[i]�����塣
     * �㿪ʼ�ó�ʱ�������ǿյġ��ص���ʼ����վ��ָ����ѡ��һ����㿪ʼ���Σ����������
     * ��Χ��������һ�Σ��ͷ��ؿ�ʼ�ļ���վ���������򷵻�-1��
     *
     * ע�⣺
     *   - �𰸱�֤��Ψһ��
     *
     * ����˼·
     * �����վ�� i ����������վ�� k ֮ǰ����Ȼ�ܱ�֤��������û���׶�����k �����󣬼��׶��ˡ�
     * ��ô��˵�� diff[i] + diff[i+1] + ... + diff[k] < 0��������diff[k]���⣬��diff[i]
     * ��ʼ���ۼӶ��� >= 0�ġ�Ҳ����˵diff[i] Ҳ�� >= 0�ģ����ʱ�����ǻ��б�Ҫ��վ�� i + 1
     * ��������ϸһ���֪������Ҫ�Ǵ�վ�� i+1����������վ��k��������û��վ��k������ͼ���
     * ���ˣ���Ϊ�ټ���վ�� i ���͡�����
     *
     * ��ˣ������Ƿ��ֵ���k վ��������׶���i �� k ��Щվ�㶼������Ϊ�������������ˣ��϶�
     * ������������ֻ��Ҫ��k+1վ�㳢�Լ��ɣ���˽ⷨʱ�临�Ӷȴ�O(n2)������ O(2n)��֮������
     * O(2n)������Ϊ��k+1վ��Ϊʼ��վ��������Ȧ����k������֤k+1�Ƿ����㡣
     *
     * �ȵȣ������Ҫ������
     * ����ģ��һ�¹��̣�
     * a. �ʼ��վ��0��ʼ��վ�����賵����վ��p��������ˣ�
     *      ����sum1 = diff[0] +diff[1] + ... + diff[p]����֪sum1 < 0��
     *
     * b. ������������������ǽ�p+1��Ϊʼ��վ������qվ�������ֿ��ˣ�
     *      ��sum2 = diff[p+1] +diff[p+2] + ... + diff[q]����֪sum2 < 0��
     *
     * c. ��q+1��Ϊʼ��վ������һֱ������δѭ������ĩվ������û���׶���
     *      ��sum3 = diff[q+1] +diff[q+2] + ... + diff[size-1]����֪sum3 >= 0��
     *
     * Ҫ��֪�����ܷ񿪻� q վ����ʵ������sum3 �Ļ����ϣ����μ��� diff[0] �� diff[q]��
     * ����sum3������������Ƿ��С��0����������֮ǰ�Ѿ�֪�� diff[0] �� diff[p-1] ���·��
     * ������һֱ���ַǸ����������ֻҪ����sum3 + sum1�Ƿ� <0����֪���ܲ��ܿ��� p+1վ�ˡ�
     * ����ܴ�p+1վ������ֻҪ����sum3 + sum1 + sum2 �Ƿ� < 0����֪���ܲ��ܿ���qվ�ˡ�
     *
     * ��Ϊ sum1, sum2 �� < 0�������� sum3 + sum1 + sum2 >=0 ��ô
     * sum3 + sum1 ��Ȼ >= 0��Ҳ����˵��ֻҪsum3 + sum1 + sum2 >=0������Ȼ�ܿ���qվ��
     * ��sum3 + sum1 + sum2 ��ʵ���� diff������ܺ� Total������������Ԫ���Ѿ�������ˡ�
     * ��� Total �ܷ� >= 0�������Ƿ����������վ��� ��ֱ�Ҫ������
     *
     * ����ʱ�临�ӶȽ�һ����O(2n)������ O(n)��
     * </pre>
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // ��������
        if (gas == null || cost == null || gas.length == 0 || gas.length != cost.length) {
            return -1;
        }

        // ��¼���ʵ���ʼ��
        int start = 0;
        // �ӵ��������ĵ������ܲ�ֵ
        int total = 0;
        // ��startλ�ÿ�ʼ���ӵ��������ĵ������ܲ�ֵ
        int sum = 0;

        for (int i = 0; i < gas.length; i++) {
            total += (gas[i] - cost[i]);

            // ��������û������
            if (sum < 0) {
                // �������������е���
                sum = gas[i] - cost[i];
                // ��¼�µ����λ��
                start = i;
            } else {
                // �����л����ͣ����������е�����
                sum += (gas[i] - cost[i]);
            }
        }

        return total >= 0 ? start : -1;
    }


    // ����ķ����ᳬʱO(N^2)ʱ�临�Ӷ�
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        // ��������
        if (gas == null || cost == null || gas.length == 0 || gas.length != cost.length) {
            return -1;
        }

        // ʣ�µ����壬��ʼʱΪ0
        int leftGas = 0;
        // ��ʼ������վ��
        int start = 0;
        // ������վ��
        int end = 1;

        // δ��һ��
        while (start < gas.length) {

            // ������һ��վ�����������
            leftGas = gas[start] - cost[start];

            // �����ߵ���һ��վ
            if (leftGas > 0) {
                // ��¼��һ��վ
                end = (start + 1) % gas.length;

                // ���һֱ���Ե���һ��վ�ͳ������в���
                while (start != end && (leftGas += (gas[end] - cost[end])) >= 0) {
                    end = (end + 1) % gas.length;
                }

                // ˵���Ѿ�������һ��
                if (start == end) {
                    return start;
                }
            }

            start++;
        }

        return -1;
    }
}
