import java.util.*;

class Solution {
    private static final int[] DX = {0, 1, 0, -1};
    private static final int[] DY = {1, 0 , -1, 0};

    public int[] solution(String[] maps) {
        int rows = maps.length;
        int cols = maps[0].length();

        int[][] grid = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                char ch = maps[r].charAt(c);
                grid[r][c] = ch == 'X' ? -1 : (ch - '0');
            }
        }

        List<Integer> sums = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == -1 || visited[r][c]) continue;
                sums.add(bfs(r, c, grid, visited, rows, cols));
            }
        }

        if (sums.isEmpty()) return new int[]{-1};

        return sums.stream()
                .sorted()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private int bfs(int r, int c, int[][] grid, boolean[][] visited, int rows, int cols) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r, c});
        visited[r][c] = true;

        int sum = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            sum += grid[x][y];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + DX[dir];
                int ny = y + DY[dir];

                if (nx < 0 || ny < 0 || nx >= rows || ny >= cols) continue;
                if (grid[nx][ny] == -1 || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
        return sum;
    }
}