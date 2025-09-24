// User function Template for C++

class Solution
{
private:
    void dfs(int row, int col, vector<vector<int>> &grid, vector<vector<int>> &vis, vector<pair<int, int>> &v, int row0, int col0)
    {
        vis[row][col] = 1;
        int n = grid.size();
        int m = grid[0].size();
        v.push_back({row - row0, col - col0});
        int dRow[4] = {-1, 0, 1, 0};
        int dCol[4] = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++)
        {
            int newRow = row + dRow[i];
            int newCol = col + dCol[i];
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !vis[newRow][newCol] && grid[newRow][newCol] == 1)
            {
                dfs(newRow, newCol, grid, vis, v, row0, col0);
            }
        }
    }
public:
    int countDistinctIslands(vector<vector<int>> &grid)
    {
        // code here - Jai Mahakal
        int n = grid.size();
        int m = grid[0].size();
        vector<vector<int>> vis(n, (vector<int>(m, 0)));
        // int vis[n][m] = {0};
        set<vector<pair<int, int>>> set;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (!vis[i][j] && grid[i][j] == 1)
                {
                    vector<pair<int, int>> v;
                    dfs(i, j, grid, vis, v, i, j);
                    set.insert(v);
                }
            }
        }
        // SC - n x m x long(nxm) + (nxmx4)
        return set.size();
    }
};
