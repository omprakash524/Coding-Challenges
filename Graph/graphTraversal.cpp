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