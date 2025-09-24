class Solution
{
    bool dfsCycleDect(int node, vector<int> &vis, vector<int> &pv, vector<int> &safe, vector<vector<int>> &graph)
    {
        vis[node] = 1;
        pv[node] = 1;
        for (int it : graph[node])
        {
            if (!vis[it])
            {
                if (dfsCycleDect(it, vis, pv, safe, graph))
                {
                    return true;
                }
            }
            else if (pv[it])
            {
                return true;
            }
        }
        pv[node] = 0;
        safe[node] = 1;
        return false;
    }

public:
    vector<int> eventualSafeNodes(vector<vector<int>> &graph)
    {
        int n = graph.size();
        int m = graph[0].size();
        vector<int> res;
        vector<int> vis(n, 0), pathVis(n, 0), safe(n, 0);
        for (int i = 0; i < n; i++)
        {
            if (!vis[i])
            {
                dfsCycleDect(i, vis, pathVis, safe, graph);
            }
        }
        for (int i = 0; i < n; i++)
        {
            if (safe[i])
            {
                res.push_back(i);
            }
        }
        return res;
    }
};

[ [ 10, 20, 30, 40 ],
  [ 15, 25, 35, 45 ],
  [ 24, 29, 37, 48 ],
  [ 32, 33, 39, 50 ] ]

    16 28 60 64 22 41 63 91 27 50 87 93 36 78 87 94 16 28 60 64 22 41 63 91 27 50 87 93 36 78 87 94
    // sort
    16 22 27 28 36 39 41 48 50 60 63 64 78 87 91 93 94