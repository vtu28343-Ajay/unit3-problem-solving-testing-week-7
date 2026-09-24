class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        while (root != null) {

            // Both p and q are smaller than root
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }

            // Both p and q are greater than root
            else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }

            // They are on different sides,
            // or root is p or q
            else {
                return root;
            }
        }

        return null;
    }
}
