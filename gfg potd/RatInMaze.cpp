#include<bits/stdc++.h>
using namespace std;
int main(){
    // Example usage of the BFS and DFS solutions
    vector<vector<int>> adj = {
        {}, // 0th index not used
        {2, 3}, // Neighbors of node 1
        {1, 4}, // Neighbors of node 2
        {1}, // Neighbors of node 3
        {2} // Neighbors of node 4
    };

    BFSSolution bfsSolution;
    vector<int> bfsResult = bfsSolution.bfs(adj);
    cout << "BFS Traversal: ";
    for (int node : bfsResult) {
        cout << node << " ";
    }
    cout << endl;

    DFSSolution dfsSolution;
    vector<int> dfsResult = dfsSolution.dfs(adj);
    cout << "DFS Traversal: ";
    for (int node : dfsResult) {
        cout << node << " ";
    }
    cout << endl;
    return 0;
}