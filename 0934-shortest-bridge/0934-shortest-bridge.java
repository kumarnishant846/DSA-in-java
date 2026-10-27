import java.util.*;

class Solution {
    int n;
    int[][] grid;
    Queue<int[]> queue = new LinkedList<>();

    public int shortestBridge(int[][] grid) {
        this.grid = grid;
        n = grid.length;

        boolean found = false;

        for (int i = 0; i < n && !found; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j);
                    found = true;
                    break;
                }
            }
        }

        int steps = 0;
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int[] current = queue.poll();
                int r = current[0];
                int c = current[1];

                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                        if (grid[nr][nc] == 1) {
                            return steps;
                        }

                        if (grid[nr][nc] == 0) {
                            grid[nr][nc] = 2;
                            queue.offer(new int[]{nr, nc});
                        }
                    }
                }
            }

            steps++;
        }

        return -1;
    }

    void dfs(int r, int c) {
        if (r < 0 || r >= n || c < 0 || c >= n || grid[r][c] != 1) {
            return;
        }

        grid[r][c] = 2;
        queue.offer(new int[]{r, c});

        dfs(r + 1, c);
        dfs(r - 1, c);
        dfs(r, c + 1);
        dfs(r, c - 1);
    }
}