class Solution {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] b = new char[n][n];
        for (char[] r : b) Arrays.fill(r, '.');
        dfs(b, 0, n);
        return ans;
    }

    void dfs(char[][] b, int r, int n) {
        if (r == n) {
            List<String> s = new ArrayList<>();
            for (char[] row : b) s.add(new String(row));
            ans.add(s);
            return;
        }

        for (int c = 0; c < n; c++) {
            if (safe(b, r, c, n)) {
                b[r][c] = 'Q';
                dfs(b, r + 1, n);
                b[r][c] = '.';
            }
        }
    }

    boolean safe(char[][] b, int r, int c, int n) {
        for (int i = 0; i < r; i++)
            if (b[i][c] == 'Q' ||
                c - r + i >= 0 && b[i][c-r+i] == 'Q' ||
                c + r - i < n && b[i][c+r-i] == 'Q')
                return false;
        return true;
    }
}