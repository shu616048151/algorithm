import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: ������
 * Date: 2015-08-21
 * Time: 18:44
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * ԭ��
     * Given a binary tree, return the level order traversal of its nodes�� values.
     * (ie, from left to right, level by level).
     * For example:
     * Given binary tree {3,9,20,#,#,15,7},
     *
     *    3
     *   / \
     *  9  20
     *    /  \
     *   15   7
     *
     * return its level order traversal as:
     *
     * [
     *  [3],
     *  [9,20],
     *  [15,7]
     * ]
     * ��Ŀ����
     * ����һ�����������������ÿһ��Ľ�㡣
     *
     * ����˼·
     * ʹ�������У�һ�����浱ǰ����Ĳ㣬һ��������һ��Ҫ����Ĳ㡣ֻ��ÿһ�㶼�����ꡣ
     * </pre>
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> cur = new LinkedList<>();
        Deque<TreeNode> sub = new LinkedList<>();
        Deque<TreeNode> exc;

        TreeNode node;
        cur.addLast(root);

        while (!cur.isEmpty()) {
            List<Integer> layout = new LinkedList<>();
            while (!cur.isEmpty()) {
                node = cur.removeFirst();
                layout.add(node.val);

                if (node.left != null) {
                    sub.addLast(node.left);
                }

                if (node.right != null) {
                    sub.addLast(node.right);
                }
            }

            exc = cur;
            cur = sub;
            sub = exc;

            result.add(layout);
        }

        return result;
    }
}
