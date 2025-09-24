#include <bits/stdc++.h>
using namespace std;
// memoization 
int fib(int n, vector<int>& dp){
    if(n <= 1) return n;
    if(dp[n] != -1) return dp[n];
    return dp[n] = fib(n-1, dp) + fib(n-2, dp);
}
int main(){
    cout<<"DP"<<endl;
    int n = 5;
    vector<int> dp(n+1, -1);
    cout << fib(n, dp) << endl;
    // TC: O(n)
    // SC: O(n)
    // Tabulation
    vector<int> dp1(n+1, 0);
    dp1[0] = 0;
    dp1[1] = 1;
    for(int i = 2; i <= n; i++){
        dp1[i] = dp1[i-1] + dp1[i-2];
    }
    cout << dp1[n] << endl;
    // TC: O(n)
    // SC: O(n)

    // space optimization
    if(n == 0){
        cout<<0;
        return 0;
    }
    if(n == 1){
        cout<<1;
        return 0;
    }
    int prev2 = 0, prev1 = 1;
    for(int i = 2; i <= n; i++){
        int curr = prev1 + prev2;
        prev2 = prev1;
        prev1 = curr;
    }
    cout << prev1 << endl;
    // TC: O(n)
    // SC: O(1)

    return 0;
}