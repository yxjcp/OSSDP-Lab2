import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 测试类设计说明：
 * 测试设计原则如下：
 * 1. 等价类划分：把输入分为不同的等价类，对每个等价类进行测试。
 *    - 有效等价类：正常的二维网格，包括含有岛屿和不含岛屿的情况。
 *    - 无效等价类：空网格、空引用网格。
 * 2. 边界值分析：测试输入参数的边界值，如最小尺寸的网格（如1x1）、最大尺寸的网格（如300x300）。
 * 3. 特殊情况测试：针对一些特殊的输入情况进行测试，如全水网格、全陆地网格、被水包围的岛屿等。
 */
public class L2022112946_8_Test {

    private Solution8 solution;

    @Before
    public void setUp() {
        solution = new Solution8();
    }

    /**
     * 测试目的：
     * 验证方法在输入为示例1时，能正确计算岛屿数量。
     *
     * 测试用例：
     * 输入示例1的网格，应返回1。
     */
    @Test
    public void testExample1() {
        char[][] grid = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        assertEquals("示例 1 应返回 1", 1, solution.numIslands(grid));
    }

    /**
     * 测试目的：
     * 验证方法在输入为示例2时，能正确计算岛屿数量。
     *
     * 测试用例：
     * 输入示例2的网格，应返回3。
     */
    @Test
    public void testExample2() {
        char[][] grid = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
        assertEquals("示例 2 应返回 3", 3, solution.numIslands(grid));
    }

    /**
     * 测试目的：
     * 验证方法在输入为空数组时，能正确处理并返回0。
     *
     * 测试用例：
     * 输入为空数组，应返回0。
     */
    @Test
    public void testEmptyGrid() {
        char[][] grid = {};
        assertEquals("空网格应返回 0", 0, solution.numIslands(grid));
    }

    /**
     * 测试目的：
     * 验证方法在输入为null时，能正确处理并返回0。
     *
     * 测试用例：
     * 输入为null，应返回0。
     */
    @Test
    public void testNullGrid() {
        char[][] grid = null;
        assertEquals("空引用网格应返回 0", 0, solution.numIslands(grid));
    }

    /**
     * 测试目的：
     * 验证方法在单行全水网格时，能正确返回0。
     *
     * 测试用例：
     * 单行全水网格，应返回0。
     */
    @Test
    public void testSingleRowAllWater() {
        char[][] grid = {
            {'0','0','0','0'}
        };
        assertEquals("单行全水网格应返回 0", 0, solution.numIslands(grid));
    }

    /**
     * 测试目的：
     * 验证方法在单行全陆地网格时，能正确返回1。
     *
     * 测试用例：
     * 单行全陆地网格，应返回1。
     */
    @Test
    public void testSingleRowAllLand() {
        char[][] grid = {
            {'1','1','1','1'}
        };
        assertEquals("单行全陆地网格应返回 1", 1, solution.numIslands(grid));
    }

    /**
     * 测试目的：
     * 验证方法在单列全水网格时，能正确返回0。
     *
     * 测试用例：
     * 单列全水网格，应返回0。
     */
    @Test
    public void testSingleColumnAllWater() {
        char[][] grid = {
            {'0'},
            {'0'},
            {'0'},
            {'0'}
        };
        assertEquals("单列全水网格应返回 0", 0, solution.numIslands(grid));
    }

    /**
     * 测试目的：
     * 验证方法在单列全陆地网格时，能正确返回1。
     *
     * 测试用例：
     * 单列全陆地网格，应返回1。
     */
    @Test
    public void testSingleColumnAllLand() {
        char[][] grid = {
            {'1'},
            {'1'},
            {'1'},
            {'1'}
        };
        assertEquals("单列全陆地网格应返回 1", 1, solution.numIslands(grid));
    }

    /**
     * 测试目的：
     * 验证方法在全水网格时，能正确返回0。
     *
     * 测试用例：
     * 全水网格，应返回0。
     */
    @Test
    public void testAllWater() {
        char[][] grid = {
            {'0','0'},
            {'0','0'}
        };
        assertEquals("全水网格应返回 0", 0, solution.numIslands(grid));
    }

    /**
     * 测试目的：
     * 验证方法在全陆地网格时，能正确返回1。
     *
     * 测试用例：
     * 全陆地网格，应返回1。
     */
    @Test
    public void testAllLand() {
        char[][] grid = {
            {'1','1'},
            {'1','1'}
        };
        assertEquals("全陆地网格应返回 1", 1, solution.numIslands(grid));
    }

    /**
     * 测试目的：
     * 验证方法在不规则岛屿形状时，能正确计算岛屿数量。
     *
     * 测试用例：
     * 不规则岛屿网格，应返回9。
     */
    @Test
    public void testIrregularIslands() {
        char[][] grid = {
            {'1','0','1','0','1'},
            {'0','1','0','1','0'},
            {'1','0','1','0','1'},
            {'0','1','0','1','0'}
        };
        assertEquals("不规则岛屿网格应返回 10", 10, solution.numIslands(grid));
    }

    /**
     * 测试目的：
     * 验证方法在被水包围的岛屿时，能正确返回1。
     *
     * 测试用例：
     * 中间有水的环形岛屿，应返回1。
     */
    @Test
    public void testSurroundedIsland() {
        char[][] grid = {
            {'1','1','1'},
            {'1','0','1'},
            {'1','1','1'}
        };
        assertEquals("被水包围的岛屿应返回 1", 1, solution.numIslands(grid));
    }

    /**
     * 测试目的：
     * 验证方法在复杂岛屿连接情况下，能正确计算岛屿数量。
     *
     * 测试用例：
     * 复杂连接的岛屿网格，应返回6。
     */
    @Test
    public void testComplexIslands() {
        char[][] grid = {
            {'1','1','0','0','1','0','1'},
            {'1','0','0','1','1','1','0'},
            {'0','1','1','0','1','0','1'},
            {'0','0','0','1','0','1','1'}
        };
        assertEquals("复杂岛屿网格应返回 6", 6, solution.numIslands(grid));
    }

    /**
     * 测试目的：
     * 验证方法在大型全水网格时，能正确返回0。
     *
     * 测试用例：
     * 300x300的全水网格，应返回0。
     */
    @Test
    public void testLargeGridAllWater() {
        int size = 300;
        char[][] grid = new char[size][size];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                grid[i][j] = '0';
            }
        }
        assertEquals("大型全水网格应返回 0", 0, solution.numIslands(grid));
    }

    /**
     * 测试目的：
     * 验证方法在大型全陆地网格时，能正确返回1。
     *
     * 测试用例：
     * 300x300的全陆地网格，应返回1。
     */
    @Test
    public void testLargeGridAllLand() {
        int size = 300;
        char[][] grid = new char[size][size];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                grid[i][j] = '1';
            }
        }
        assertEquals("大型全陆地网格应返回 1", 1, solution.numIslands(grid));
    }

    /**
     * 测试目的：
     * 验证方法在大型混合网格中有多个岛屿时，能正确计算岛屿数量。
     *
     * 测试用例：
     * 在10x10的网格中手动设置3个岛屿，应返回3。
     */
    @Test
    public void testMixedLargeGrid() {
        // 创建一个较大的网格，手动设定部分岛屿
        int size = 10; // 为示例简化，实际可以设置为300
        char[][] grid = new char[size][size];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                grid[i][j] = '0';
            }
        }
        // 设置几个岛屿
        grid[0][0] = '1';
        grid[0][1] = '1';
        grid[1][0] = '1';
        grid[5][5] = '1';
        grid[5][6] = '1';
        grid[6][5] = '1';
        grid[9][9] = '1';
        assertEquals("混合大型网格应返回 3", 3, solution.numIslands(grid));
    }
}
