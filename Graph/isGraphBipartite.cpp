class Solution
{
private:
    bool dfs(int node, int col, vector<int> &colorArr, vector<vector<int>> &graph)
    {
        colorArr[node] = col;
        for (auto n : graph[node])
        {
            if (colorArr[n] == -1)
            {
                dfs(n, !col, colorArr, graph);
            }
            else if (colorArr[n] == col)
            {
                return false;
            }
        }
        return true;
    }

protected:
    bool bfs(vector<vector<int>> &graph, vector<int> &color)
    {
        int n = graph.size();
        for (int start = 0; start < n; start++)
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
                    for (int neighbour : graph[node])
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

public:
    bool isBipartite(vector<vector<int>> &graph)
    {
        int n = graph.size();
        int m = graph[0].size();
        // Breadth-First Search
        vector<int> color(n, -1);
        // return bfs(graph, color);
        // Depth-First Search
        for (int i = 0; i < n; i++)
        {
            if (color[i] == -1)
            {
                if (dfs(i, 0, color, graph) == false)
                {
                    return false;
                }
            }
        }
        return true;
    }
};