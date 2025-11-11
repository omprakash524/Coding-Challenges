
#include <bits/stdc++.h>
using namespace std;


class Solution
{
private:
    void dfs(int row, int col, vector<vector<int>> &grid, vector<vector<int>> &vis, int &count)
    {
        int n = grid.size();
        int m = grid[0].size();
        vis[row][col] = 1;
        int deltaRow[] = {-1, 0, 1, 0};
        int deltaCol[] = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++)
        {
            int newRow = row + deltaRow[i];
            int newCol = col + deltaCol[i];
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !vis[newRow][newCol] && grid[newRow][newCol] == 1)
            {
                count++;
                dfs(newRow, newCol, grid, vis, count);
            }
        }
    }
    // TC: O(N*M)
    // SC: O(N*M)
protected:
    void bfs(int row, int col, vector<vector<int>> &grid, vector<vector<int>> &vis, int &count)
    {
        int n = grid.size();
        int m = grid[0].size();
        vis[row][col] = 1;
        queue<pair<int, int>> q;
        q.push({row, col});
        int deltaRow[] = {-1, 0, 1, 0};
        int deltaCol[] = {0, 1, 0, -1};
        while (!q.empty())
        {
            auto [r, c] = q.front();
            q.pop();
            for (int i = 0; i < 4; i++)
            {
                int newRow = r + deltaRow[i];
                int newCol = c + deltaCol[i];
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !vis[newRow][newCol] && grid[newRow][newCol] == 1)
                {
                    count++;
                    vis[newRow][newCol] = 1;
                    q.push({newRow, newCol});
                }
            }
        }
    }
    // TC: O(N*M)
    // SC: O(N*M)
public:
    int maxAreaOfIsland(vector<vector<int>> &grid)
    {
        int n = grid.size();
        int m = grid[0].size();
        vector<vector<int>> vis(n, vector<int>(m, 0));
        int count = 0;
        int maxArea = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (!vis[i][j] && grid[i][j] == 1)
                {
                    count = 1;
                    dfs(i, j, grid, vis, count);
                    // bfs(i, j, grid, vis, count);
                    maxArea = max(maxArea, count);
                }
            }
        }
        return maxArea;
    }

public:
    int maxAreaOfIsland(vector<vector<int>> &grid)
    {
        int n = grid.size();
        int m = grid[0].size();
        vector<vector<int>> vis(n, vector<int>(m, 0));
        int maxArea = 0;

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (!vis[i][j] && grid[i][j] == 1)
                {
                    int count = 1;
                    // Choose DFS or BFS
                    dfs(i, j, grid, vis, count);
                    // bfs(i, j, grid, vis, count);
                    maxArea = max(maxArea, count);
                }
            }
        }
        return maxArea;
    }
};

// https://leetcode.com/problems/max-area-of-island/

int main(){
    int n, m;
    cout << "Enter rows and columns: ";
    cin >> n >> m;

    vector<vector<int>> grid(n, vector<int>(m));
    cout << "Enter grid values (0 or 1):\n";
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            cin >> grid[i][j];
        }
    }

    Solution sol;
    int result = sol.maxAreaOfIsland(grid);
    cout << "Max Area of Island: " << result << endl;

    return 0;
}
