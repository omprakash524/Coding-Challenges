#include <bits/stdc++.h>
using namespace std;

int main()
{
    // ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    int n;
    cin >> n;
    vector<vector<int>> adjList(n); // Corrected to vector of vectors
    for (int i = 0; i < n - 1; i++){ // Corrected loop to run n-1 times
        int u, v;
        cin >> u >> v;
        adjList[u].push_back(v);
        adjList[v].push_back(u);
    }
    vector<int> visited(n, 0);
    for (int i = 0; i < n; i++)
    {
        if (!visited[i])
        {
            queue<int> q;
            q.push(i);
            visited[i] = 1;
            while (!q.empty())
            {
                int node = q.front();
                q.pop();
                cout << node << " ";
                for (int j = 0; j < adjList[node].size(); j++)
                {
                    if (!visited[adjList[node][j]])
                    {
                        visited[adjList[node][j]] = 1;
                        q.push(adjList[node][j]);
                    }
                }
            }
        }
    }
    cout << endl;
    return 0;
}
