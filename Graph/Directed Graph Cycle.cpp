class Solution
{
private:
    bool dfs(int node, vector<int> &vis, vector<int> &pathVis, vector<vector<int>> &edges)
    {
        vis[node] = 1;
        pathVis[node] = 1;
        for (int neighbour : edges[node])
        {
            if (!vis[neighbour])
            {
                if (dfs(neighbour, vis, pathVis, edges))
                {
                    return true;
                }
            }
            else if (pathVis[neighbour])
            {
                return true;
            }
        }
        pathVis[node] = 0;
        return false;
    }

public:
    bool isCyclic(int V, vector<vector<int>> &edges)
    {
        vector<int> vis(V, 0);
        vector<int> pathVis(V, 0);
        vector<vector<int>> adj(V);

        for (auto &edge : edges)
        {
            adj[edge[0]].push_back(edge[1]);
        }

        for (int i = 0; i < V; i++)
        {
            if (!vis[i])
            {
                if (dfs(i, vis, pathVis, adj))
                {
                    return true;
                }
            }
        }
        return false;
    }
};