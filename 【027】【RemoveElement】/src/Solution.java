/**
 * Author: ������
 * Date: 2015-08-21
 * Time: 16:43
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * ԭ��
     * Given an array and a value, remove all instances of that value in place and return the new length.
     *  The order of elements can be changed. It doesn��t matter what you leave beyond the new length.
     *
     * ��Ŀ����
     * ����һ�������һ��ֵ��ɾ�������������ֵ��ȵ�Ԫ�أ����ҷ��������������µĳ��ȡ�
     *
     * ����˼·
     * �������ֵΪelem��Ԫ�ص�λ�ã�j���ұ���ֵ��Ϊelem��Ԫ�ص�λ�ã�Ȼ��jλ�õ���ֵ�ƶ���iλ�á�
     * </pre>
     *
     * @param A
     * @param elem
     * @return
     */
    public int removeElement(int[] A, int elem) {
        int exchange = 0; // ��¼�����Ĵ�����Ҳ����ͳ����������elemԪ��ֵ��ȵĸ���

        // �㷨˼�룺i�������ֵΪelem��Ԫ�ص�λ�ã�j���ұ���ֵ��Ϊelem��Ԫ�ص�λ�ã�
        // ȡ�Ⱥ����ó���Ϊ1��������Խ���
        for (int i = 0, j = A.length - 1; i <= j; i++) {
            if (A[i] == elem) { // �ҵ�Ҫ������Ԫ��
                exchange++;

                while (j > i && A[j] == elem) { // ��������濪ʼ��ǰ�ҵ�һ��������elem��Ԫ��
                    exchange++; // ��ֵΪelem��Ԫ��˵��Ҫ���������ǽ������̿���ʡȥ
                    j--;
                }

                // ���1��������Ϊelem��Ԫ�ص�λ�ã���jλ�õ�Ԫ�طŵ�iλ��
                // ���2��û���ҵ���elem��Ԫ�ص�λ�ã���i�������Ԫ��ֵ����e����ʱ��j=i
                // �������������j�е�ֵ����i��û�й�ϵ
                A[i] = A[j];
                j--; // j�Ѿ�������ʹ�������Ի�Ҫ��ǰ�ƶ���һ���µ�λ��
            }
        }

        return A.length - exchange;
    }
}
