class Solution
{
private:
    void dfs(int row, int col, vector<vector<char>> &b, vector<vector<int>> &vis)
    {
        int n = b.size();
        int m = b[0].size();
        vis[row][col] = 1;
        int drow[4] = {-1, 0, 1, 0};
        int dcol[4] = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++)
        {
            int newRow = row + drow[i];
            int newCol = col + dcol[i];
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && b[newRow][newCol] == 'O' && !vis[newRow][newCol])
            {
                dfs(newRow, newCol, b, vis);
            }
        }
        /*
        vis[row][col] = 1;
        // up
        if(b[row-1][col] == 'O' && row-1 >= 0 && row < n && col < m && !vis[row-1][col]){
            dfs(row-1, col, b, vis);
        }
        // right
        if(b[row][col+1] == 'O' && row < n && col < m && !vis[row][col+1]){
            dfs(row, col+1, b, vis);
        }
        // down
        if(b[row+1][col] == 'O' && row < n && col < m && !vis[row+1][col]){
            dfs(row+1, col, b, vis);
        }
        // left
        if(b[row][col-1] == 'O' && col-1 >= 0 && row < n && col < m && !vis[row][col-1]){
            dfs(row, col-1, b, vis);
        }
        b[row][col] = 'X';
        */
    }

public:
    void solve(vector<vector<char>> &board)
    {
        int n = board.size();
        int m = board[0].size();
        vector<vector<int>> vis(n, vector<int>(m, 0));
        // traverse only to border O's and mark vis
        // 1st and last row
        for (int j = 0; j < m; j++)
        {
            if (board[0][j] == 'O' && !vis[0][j])
            {
                dfs(0, j, board, vis);
            }
            if (board[n - 1][j] == 'O' && !vis[n - 1][j])
            {
                dfs(n - 1, j, board, vis);
            }
        }
        // 1st and last column
        for (int j = 0; j < n; j++)
        {
            if (board[j][0] == 'O' && !vis[j][0])
            {
                dfs(j, 0, board, vis);
            }
            if (board[j][m - 1] == 'O' && !vis[j][m - 1])
            {
                dfs(j, m - 1, board, vis);
            }
        }
        // remaining 'O' in middle chage to 'X'
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (board[i][j] == 'O' && !vis[i][j])
                {
                    board[i][j] = 'X';
                }
            }
        }
    }
};