class Solution
{
private:
    void dfs(vector<vector<int>> &grid, vector<vector<int>> &vis, int row, int col)
    {
        int n = grid.size();
        int m = grid[0].size();
        int dRow[4] = {-1, 0, 1, 0};
        int dCol[4] = {0, 1, 0, -1};
        vis[row][col] = 1;
        for (int i = 0; i < 4; i++)
        {
            int newRow = row + dRow[i];
            int newCol = col + dCol[i];
            if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && grid[newRow][newCol] == 1 && !vis[newRow][newCol])
            {
                dfs(grid, vis, newRow, newCol);
            }
        }
    }

public:
    int numEnclaves(vector<vector<int>> &grid)
    {
        int n = grid.size();
        int m = grid[0].size();
        vector<vector<int>> vis(n, vector<int>(m, 0));
        // 1st row and last row
        for (int j = 0; j < n; j++)
        {
            if (grid[j][0] == 1 && !vis[j][0])
            {
                dfs(grid, vis, j, 0);
            }
            if (grid[j][m - 1] == 1 && !vis[j][m - 1])
            {
                dfs(grid, vis, j, m - 1);
            }
        }
        // 1st col and last col
        for (int j = 0; j < m; j++)
        {
            if (grid[0][j] == 1 && !vis[0][j])
            {
                dfs(grid, vis, 0, j);
            }
            if (grid[n - 1][j] == 1 && !vis[n - 1][j])
            {
                dfs(grid, vis, n - 1, j);
            }
        }
        // count in boundry 1's
        int count = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (grid[i][j] == 1 && !vis[i][j])
                {
                    count++;
                }
            }
        }
        return count;
    }
};

