class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] inDegree = new int[n + 1];
        int[] outDegree = new int[n + 1];

        for (int[] t : trust) {
            int a = t[0];
            int b = t[1];

            outDegree[a]++;
            inDegree[b]++;
        }

        for (int person = 1; person <= n; person++) {
            if (inDegree[person] == n - 1 && outDegree[person] == 0) {
                return person;
            }
        }

        return -1;
    }
}
