class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {
                provinces++;

                dfs(i, isConnected, visited);
            }
        }

        return provinces;
    }

    private void dfs(int city, int[][] isConnected, boolean[] visited) {
        visited[city] = true;

        for (int nextCity = 0; nextCity < isConnected.length; nextCity++) {

            if (isConnected[city][nextCity] == 1 &&
                !visited[nextCity]) {

                dfs(nextCity, isConnected, visited);
            }
        }
    }
}
