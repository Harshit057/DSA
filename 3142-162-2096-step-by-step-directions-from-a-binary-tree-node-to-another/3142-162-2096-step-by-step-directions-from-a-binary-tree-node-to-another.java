import java.util.*;

public class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = findLCA(root, startValue, destValue);

        StringBuilder pathToStart = new StringBuilder();
        StringBuilder pathToDest = new StringBuilder();

        findPath(lca, startValue, pathToStart);
        findPath(lca, destValue, pathToDest);

        // 'U' for each step from start to LCA + path from LCA to dest
        return "U".repeat(pathToStart.length()) + pathToDest.toString();
    }

    // Find path from root to target and build directions
    private boolean findPath(TreeNode node, int target, StringBuilder path) {
        if (node == null) return false;
        if (node.val == target) return true;

        path.append('L');
        if (findPath(node.left, target, path)) return true;
        path.deleteCharAt(path.length() - 1);

        path.append('R');
        if (findPath(node.right, target, path)) return true;
        path.deleteCharAt(path.length() - 1);

        return false;
    }

    // Standard LCA finder
    private TreeNode findLCA(TreeNode node, int p, int q) {
        if (node == null || node.val == p || node.val == q) return node;
        TreeNode left = findLCA(node.left, p, q);
        TreeNode right = findLCA(node.right, p, q);
        if (left != null && right != null) return node;
        return left != null ? left : right;
    }
}
