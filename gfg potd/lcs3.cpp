class Solution {
    int dp[101][101][101]; // For 3-string LCS
    int dp2[101][101];     // For 2-string LCS

    private:
    // 3-string LCS
    int solve(string& s1, string& s2, string& s3, int i, int j, int k){
        if(i >= s1.size() || j >= s2.size() || k >= s3.size()) return 0;
        if(dp[i][j][k] != -1) return dp[i][j][k];

        if(s1[i] == s2[j] && s2[j] == s3[k])
            return dp[i][j][k] = 1 + solve(s1, s2, s3, i + 1, j + 1, k + 1);
        
        return dp[i][j][k] = max({
            solve(s1, s2, s3, i + 1, j, k),
            solve(s1, s2, s3, i, j + 1, k),
            solve(s1, s2, s3, i, j, k + 1)
        });
    }

    // 2-string LCS
    int solve2(string& s1, string& s2, int i, int j){
        if(i >= s1.size() || j >= s2.size()) return 0;
        if(dp2[i][j] != -1) return dp2[i][j];

        if(s1[i] == s2[j])
            return dp2[i][j] = 1 + solve2(s1, s2, i + 1, j + 1);
        
        return dp2[i][j] = max(
            solve2(s1, s2, i + 1, j),
            solve2(s1, s2, i, j + 1)
        );
    }

public:
    int lcsOf3(string& s1, string& s2, string& s3) {
        memset(dp, -1, sizeof(dp));
        return solve(s1, s2, s3, 0, 0, 0);
    }

    // int lcsOf2(string& s1, string& s2) {
    //     memset(dp2, -1, sizeof(dp2));
    //     return solve2(s1, s2, 0, 0);
    // }
};
