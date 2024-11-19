/**
 * @description:
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *
 *
 * 示例 1：
 *
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 *
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
 *
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] 的值为 '0' 或 '1'
 *
 */
import java.util.Stack;

class Solution8 {
    private void dfsIterative(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        // 使用栈来模拟递归
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{r, c});
        grid[r][c] = '0'; // 标记为已访问

        // 四个方向
        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        while (!stack.isEmpty()) {
            int[] cell = stack.pop();
            int row = cell[0];
            int col = cell[1];

            for (int[] d : directions) {
                int newRow = row + d[0];
                int newCol = col + d[1];
                // 检查边界和是否为陆地
                if (newRow >= 0 && newRow < nr && newCol >= 0 && newCol < nc && grid[newRow][newCol] == '1') {
                    stack.push(new int[]{newRow, newCol});
                    grid[newRow][newCol] = '0'; // 标记为已访问
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int numIslands = 0;

        // 遍历每个格子
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                // 如果当前格子是陆地
                if (grid[r][c] == '1') {
                    numIslands++;
                    dfsIterative(grid, r, c);
                }
            }
        }

        return numIslands; // 返回岛屿数量
    }
}
