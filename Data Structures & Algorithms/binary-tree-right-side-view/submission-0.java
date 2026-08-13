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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> result = new ArrayList();
        Queue<TreeNode> q = new LinkedList<>();

        if(root != null){
            q.add(root);
        }

        while(!q.isEmpty()){
            result.add(q.peek().val);
            for(int i=q.size(); i>0; i--){
                TreeNode t = q.poll();

                if(t.right!=null){
                    q.add(t.right);
                }

                if(t.left!=null){
                    q.add(t.left);
                }
            }
        }
        return result;
    }
}
