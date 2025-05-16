#include <bits/stdc++.h>
using namespace std;

class Solution{
    void dfsRepetative(vector<vector<int>> &image, int row, int col, int color, int givenData, vector<vector<int>> &vis){
        vis[row][col] = 1;
        image[row][col] = color;
        // move up
        if (row > 0 && !vis[row - 1][col] && image[row - 1][col] == givenData){
            dfsRepetative(image, row - 1, col, color, givenData, vis);
        }
        // move down
        if (row < image.size() - 1 && !vis[row + 1][col] && image[row + 1][col] == givenData){
            dfsRepetative(image, row + 1, col, color, givenData, vis);
        }
        // move left
        if (col > 0 && !vis[row][col - 1] && image[row][col - 1] == givenData){
            dfsRepetative(image, row, col - 1, color, givenData, vis);
        }
        // move right
        if (col < image[0].size() - 1 && !vis[row][col + 1] && image[row][col + 1] == givenData){
            dfsRepetative(image, row, col + 1, color, givenData, vis);
        }
    }
    void depthFirstSearch(vector<vector<int>> &image, int row, int col, int color, int givenData, vector<vector<int>> &vis){
        vis[row][col] = 1;
        image[row][col] = color;
        if (row > 0 && !vis[row - 1][col] && image[row - 1][col] == givenData){
            depthFirstSearch(image, row - 1, col, color, givenData, vis);
        }
        if (row < image.size() - 1 && !vis[row + 1][col] && image[row + 1][col] == givenData){
            depthFirstSearch(image, row + 1, col, color, givenData, vis);
        }
        if (col > 0 && !vis[row][col - 1] && image[row][col - 1] == givenData){
            depthFirstSearch(image, row, col - 1, color, givenData, vis);
        }
        if (col < image[0].size() - 1 && !vis[row][col + 1] && image[row][col + 1] == givenData){
            depthFirstSearch(image, row, col + 1, color, givenData, vis);
        }
    }

private:
    void dfs(vector<vector<int>> &image, int row, int col, int color, int givenData, vector<vector<int>> &vis){
        vis[row][col] = 1;
        image[row][col] = color;
        int directions[4][2] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (auto dir : directions){
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newRow < image.size() && newCol >= 0 && newCol < image[0].size() &&
                !vis[newRow][newCol] && image[newRow][newCol] == givenData){
                dfs(image, newRow, newCol, color, givenData, vis);
            }
        }
    }

public:
    vector<vector<int>> floodFill(vector<vector<int>> &image, int sr, int sc, int color){
        int n = image.size();
        int m = image[0].size();
        vector<vector<int>> vis(n, vector<int>(m, 0));
        int givenData = image[sr][sc];
        dfs(image, sr, sc, color, givenData, vis);
        return image;
    }
};

int main(){
    int n, m, sr, sc, color;
    cin >> n >> m >> sr >> sc >> color;
    vector<vector<int>> image(n, vector<int>(m));
    for (int i = 0; i < n; ++i){
        for (int j = 0; j < m; ++j){
            cin >> image[i][j];
        }
    }

    Solution sol;
    vector<vector<int>> result = sol.floodFill(image, sr, sc, color);
    for (const auto &row : result){
        for (const auto &pixel : row){
            cout << pixel << " ";
        }
        cout << endl;
    }
    return 0;
}

