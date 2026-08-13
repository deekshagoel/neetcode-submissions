/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();

        TreeNode cur = root;
        if(root == null){
            return result;
        }
        queue.offer(cur);

        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList();
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode q = queue.poll();

                if(q.left!=null){
                    queue.offer(q.left);
                }
                if(q.right!=null){
                    queue.offer(q.right);
                }
                level.add(q.val);
            }
            result.add(level);
        }
        return result;
    }
}
