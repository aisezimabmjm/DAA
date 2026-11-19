import java.util.*;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root != null) {
            dfs(root, new StringBuilder(), paths);
        }
        return paths;
    }

    private void dfs(TreeNode node, StringBuilder path, List<String> paths) {
        int len = path.length();
        path.append(node.val);

        if (node.left == null && node.right == null) {
            paths.add(path.toString());
        } else {
            path.append("->");
            if (node.left != null) dfs(node.left, path, paths);
            if (node.right != null) dfs(node.right, path, paths);
        }

        path.setLength(len); // Backtrack
    }
}
