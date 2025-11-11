#include <bits/stdc++.h>
using namespace std;
class BFSSolution
{
public:
    // Breadth First Traversal of graph.
    vector<int> bfs(vector<vector<int>> &adj){
        int n = adj.size();
        int vis[n] = {0};
        vector<int> ans;
        queue<int> q;
        q.push(1);
        vis[1] = 1;
        while (!q.empty()){
            int node = q.front();
            q.pop();
            ans.emplace_back(node);
            for (auto it : adj[node]){
                if (!vis[it]){
                    q.push(it);
                    vis[it] = 1;
                }
            }
        }
        return ans;
    }
};
class DFSSolution
{
private:
    void dfs(int node, vector<vector<int>> adj, int vis[], vector<int> &ans){
        vis[node] = 1;
        ans.emplace_back(node);
        for (auto it : adj[node]){
            if (!vis[it]){
                dfs(it, adj, vis, ans);
            }
        }
    }
class Solution {
    private:
    void dfs(int row, int col, vector<vector<int>>& grid, vector<vector<int>>& vis, int &count){
        int n = grid.size();
        int m = grid[0].size();
        vis[row][col] = 1;
        int deltaRow[] = {-1, 0, 1, 0};
        int deltaCol[] = {0, 1, 0, -1};
        for(int i = 0; i < 4; i++){
            int newRow = row + deltaRow[i];
            int newCol = col + deltaCol[i];
            if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !vis[newRow][newCol] && grid[newRow][newCol] == 1){
                count++;
                dfs(newRow, newCol, grid, vis, count);
            }
        }
    }
    // TC: O(N*M)
    // SC: O(N*M)
    protected:
    void bfs(int row, int col, vector<vector<int>> & grid, vector<vector<int>> & vis, int & count){
        int n = grid.size();
        int m = grid[0].size();
        vis[row][col] = 1;
        queue<pair<int, int>> q;
        q.push({row, col});
        int deltaRow[] = {-1, 0, 1, 0};
        int deltaCol[] = {0, 1, 0, -1};
        while(!q.empty()){
            auto [r, c] = q.front();
            q.pop();
            for(int i = 0; i < 4; i++){
                int newRow = r + deltaRow[i];
                int newCol = c + deltaCol[i];
                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !vis[newRow][newCol] && grid[newRow][newCol] == 1){
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
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        vector<vector<int>> vis(n, vector<int>(m, 0));
        int count = 0;
        int maxArea = 0;
        for(int i = 0; i < n; i++){
          for(int j = 0; j < m; j++){
            if(!vis[i][j] && grid[i][j] == 1){
                count = 1;
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
public:
    // Depth First Traversal of graph.
    vector<int> dfs(vector<vector<int>> &adj)
    {
        int start_node = 1;
        int n = adj.size();
        int vis[n] = {0};
        vector<int> ans;
        dfs(start_node, adj, vis, ans);
        return ans;
    }
};
int main()
{
    int n, m;
    cin >> n >> m;
    vector<vector<int>> adj(n + 1);
    for (int i = 0; i < m; i++)
    {
        int u, v;
        cin >> u >> v;
        if (u > n || v > n)
        {
            cout << "Invalid edge: " << u << " - " << v << endl;
            continue;
        }
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    cout << "Adjacency List:\n";
    for (int i = 1; i <= n; i++)
    {
        cout << i << " : ";
        for (auto it : adj[i])
        {
            cout << it << " ";
        }
        cout << endl;
    }
    DFSSolution dfsSol;
    vector<int> dfs_sol = dfsSol.dfs(adj);
    cout << "DFS Traversal " << endl;
    for (auto node : dfs_sol){
        cout << node << " ";
    }
    cout << endl;

    BFSSolution bfsSol;
    vector<int> bfs_sol = bfsSol.bfs(adj);
    cout << "BFS Traversal " << endl;
    for (auto node : bfs_sol)
    {
        cout << node << " ";
    }
    cout << endl;

    return 0;
}