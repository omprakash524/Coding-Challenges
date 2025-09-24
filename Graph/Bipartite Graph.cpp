class Solution
{
public:
    bool isBipartite(int V, vector<vector<int>> &edges)
    {
        // Code here
        // convert the edge list to an adjacency list
        vector<vector<int>> adj(V);
        for (auto &edge : edges){
            int u = edge[0], v = edge[1];
            adj[u].push_back(v);
            adj[v].push_back(u);
        }

        int n = edges.size();
        vector<int> color(V, -1);
        for (int start = 0; start < V; start++)
        {
            if (color[start] == -1)
            {
                queue<int> q;
                q.push(start);
                color[start] = 0;
                while (!q.empty())
                {
                    int node = q.front();
                    q.pop();
                    for (int neighbour : adj[node])
                    {
                        if (color[neighbour] == -1)
                        {
                            color[neighbour] = 1 - color[node];
                            q.push(neighbour);
                        }
                        else if (color[neighbour] == color[node])
                        {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
};