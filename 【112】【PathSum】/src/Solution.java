/**
 * Author: ������
 * Date: 2015-08-21
 * Time: 18:56
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    private boolean stop = false; // �ж��Ƿ��Ѿ��ҵ���

    /**
     * <pre>
     * ԭ��
     * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
     * such that adding up all the values along the path equals the given sum.
     * For example:
     * Given the below binary tree and sum = 22,
     *
     *       5
     *      / \
     *     4   8
     *    /   / \
     *   11  13  4
     *  /  \      \
     * 7    2      1
     *
     * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
     *
     * ��Ŀ����
     * ����һ�ö�������һ���ͣ��жϴ����ĸ���㵽Ҷ�ӽ������н��ĺ��Ƿ���ڸ����ĺͣ�������ڣ�
     * �ͷ���true�����򷵻�false��
     *
     * ����˼·
     * �������б���������ʹ�û��ݷ�������⡣
     * </pre>
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        calculate(root, 0, sum);
        return stop;
    }

    /**
     * �������Ҷ�ӽ��ĺ�
     *
     * @param node ��ǰ����Ľڵ�
     * @param cur  �Ӹ��ڵ㵽��ǰ���֮ǰ�����нڵ��
     * @param sum  Ҫ��ĺ�
     */
    private void calculate(TreeNode node, int cur, int sum) {
        if (!stop && node != null) { // ��û���ҵ��𰸣�����Ҫ����Ľڵ㲻Ϊ��

            // �����Ҷ�ڵ㣬�ͼ��Ӹ�����ǰҶ�ڵ�ĺ��Ƿ�Ϊsum������Ǿ�˵���Ѿ��ҵ����ı�stop
            if (node.left == null && node.right == null && (node.val + cur == sum)) {
                stop = true;
            }

            // ����Ƿ�Ҷ�ڵ㣬��������
            if (node.left != null) {
                calculate(node.left, cur + node.val, sum);
            }

            if (node.right != null) {
                calculate(node.right, cur + node.val, sum);
            }
        }
    }
}
