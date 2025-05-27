#include<bits/stdc++.h>
using namespace std;
class Solution{
    public:
    int solve(int m, int n, int x, int sum){
        if(n == 0) return (sum == x)?1:0;
        int ways = 0;
        for(int i=1; i<=m; i++){
            if(sum+i <= x){
                ways += solve(m, n-1, x, sum+i);
            }
        }
        return ways;
    }
};
int main(){
    Solution sol;
    int m = 6, n = 2, x = 7;
    cout << sol.solve(m, n, x, 0) << endl;
    return 0;
}