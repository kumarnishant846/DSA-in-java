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
    List<TreeNode> list = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return build(0, list.size() - 1);
    }

    void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        list.add(root);
        inorder(root.right);
    }

    TreeNode build(int l, int r) {
        if (l > r) return null;

        int mid = (l + r) / 2;
        TreeNode root = list.get(mid);

        root.left = build(l, mid - 1);
        root.right = build(mid + 1, r);

        return root;
    }
}