#include <bits/stdc++.h>
using namespace std;
int main(){
    // adjacency matrix representation of graph
    /*
    int n; // nodes;
    int m; // edges
    cin>>n>>m;
    int adj[n+1][n+1] = {0};
    for(int i=0; i<m; i++){
        int u,v;
        cin>>u>>v;
        adj[u][v] = 1;
        adj[v][u] = 1;
    }
    for(int i=1; i<=n; i++){
        for(int j=1; j<=n; j++){
            cout<<adj[i][j]<<" ";
        }cout<<endl;
    }
    */

    // adjacency list representation of graph
    
    int n; // nodes;
    int m; // edges
    cin>>n>>m;
    vector<int> adj[n+1];
    for(int i=0; i<m; i++){
        int u,v;
        cin>>u>>v;
        adj[u].push_back(v);
        adj[v].push_back(u); // its not required when directed graph
    }
    for(int i=1; i<=n; i++){
        cout<<i<<" : ";
        for(int neighbour : adj[i]){
            cout<<neighbour<<" ";
        }
        cout<<endl;
    }
    

    // adjacency list representation of Weighted graph
    // int n, m;
    // cin >> n >> m;
    // vector<pair<int, int>> adj[n + 1];
    // for (int i = 0; i < m; i++){
    //     int u, v, w;
    //     cin >> u >> v >> w;
    //     adj[u].push_back({v, w});
    //     adj[v].push_back({u, w});
    // }
    // for (int i = 1; i <= n; i++){
    //     cout << i << " ";
    //     for (pair<int, int> neighbour : adj[i]){
    //         cout << "(node: " << neighbour.first << ", weight: " << neighbour.second << ")" << " ";
    //     }
    //     cout << endl;
    // }

    // int n,m;
    // cin>>n>>m;
    // vector<pair<int, int>> adj[n+1];
    // for(int i=0; i<m; i++){
    //     int u,v,w;
    //     cin>>u>>v>>w;
    //     adj[u].push_back({v,w});
    //     adj[v].push_back({u,w});
    // }
    // for(int i=1; i<= n; i++){
    //     cout<<i<<" : ";
    //     for(pair<int, int> n : adj[i]){
    //         cout<<n.first<<" "<<n.second<<" ";
    //     }cout<<endl;
    // }

    // Weighted Graph
    /*
    int n; // nodes;
    int m; // edges
    cin>>n>>m;
    int adj[n+1][n+1] = {0};
    for(int i=0; i<m; i++){
        int u,v, w;
        cout<<"enter u : ";
        cin>>u;
        cout<<"enter v : ";
        cin>>v;
        cout<<"enter weight : ";
        cin>>w;
        adj[u][v] = w;
        adj[v][u] = w;
    }
    for(int i=1; i<=n; i++){
        for(int j=1; j<=n; j++){
            cout<<adj[i][j]<<" ";
        }cout<<endl;
    }
    */
   cout<<""<<endl;

    return 0;
}