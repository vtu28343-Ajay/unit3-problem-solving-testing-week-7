import java.util.*;

class Solution {
    class Point {
        int col, row, val;
        Point(int col, int row, int val) {
            this.col = col;
            this.row = row;
            this.val = val;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<Point> points = new ArrayList<>();
        dfs(root, 0, 0, points);
        
        Collections.sort(points, (a, b) -> {
            if (a.col != b.col) return Integer.compare(a.col, b.col);
            if (a.row != b.row) return Integer.compare(a.row, b.row);
            return Integer.compare(a.val, b.val);
        });
        
        List<List<Integer>> result = new ArrayList<>();
        Integer lastCol = null;
        List<Integer> currentList = null;
        
        for (Point p : points) {
            if (lastCol == null || p.col != lastCol) {
                lastCol = p.col;
                currentList = new ArrayList<>();
                result.add(currentList);
            }
            currentList.add(p.val);
        }
        
        return result;
    }

    private void dfs(TreeNode node, int row, int col, List<Point> points) {
        if (node == null) return;
        points.add(new Point(col, row, node.val));
        dfs(node.left, row + 1, col - 1, points);
        dfs(node.right, row + 1, col + 1, points);
    }
}