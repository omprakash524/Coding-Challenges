#include <bits/stdc++.h>
using namespace std;

// Fast IO
#define fast_io                  \
    ios::sync_with_stdio(false); \
    cin.tie(NULL);

// Aliases
using ll = long long;
using ld = long double;
using ull = unsigned long long;
using pii = pair<int, int>;
using pll = pair<ll, ll>;
using vi = vector<int>;
using vll = vector<ll>;
using vpi = vector<pii>;
using vpll = vector<pll>;

// Macros
#define pb push_back
#define mp make_pair
#define ff first
#define ss second
#define all(x) (x).begin(), (x).end()
#define sz(x) (int)(x).size()
#define rep(i, a, b) for (int i = a; i < b; ++i)
#define rrep(i, a, b) for (int i = a; i >= b; --i)

// Constants
const int INF = 1e9;
const ll LINF = 1e18;
const int MOD = 1e9 + 7; // or 998244353 if needed

// Debugging (comment out before submitting)
#ifndef ONLINE_JUDGE
#define debug(x)         \
    cerr << #x << " = "; \
    _print(x);           \
    cerr << endl;
#else
#define debug(x)
#endif

void _print(int x) { cerr << x; }
void _print(ll x) { cerr << x; }
void _print(string x) { cerr << x; }
void _print(char x) { cerr << x; }
void _print(ld x) { cerr << x; }
void _print(double x) { cerr << x; }
void _print(ull x) { cerr << x; }

template <class T, class V>
void _print(pair<T, V> p);
template <class T>
void _print(vector<T> v);
template <class T>
void _print(set<T> v);
template <class T, class V>
void _print(map<T, V> v);
template <class T>
void _print(multiset<T> v);

template <class T, class V>
void _print(pair<T, V> p)
{
    cerr << "{";
    _print(p.ff);
    cerr << ",";
    _print(p.ss);
    cerr << "}";
}
template <class T>
void _print(vector<T> v)
{
    cerr << "[ ";
    for (T i : v)
    {
        _print(i);
        cerr << " ";
    }
    cerr << "]";
}
template <class T>
void _print(set<T> v)
{
    cerr << "[ ";
    for (T i : v)
    {
        _print(i);
        cerr << " ";
    }
    cerr << "]";
}
template <class T>
void _print(multiset<T> v)
{
    cerr << "[ ";
    for (T i : v)
    {
        _print(i);
        cerr << " ";
    }
    cerr << "]";
}
template <class T, class V>
void _print(map<T, V> v)
{
    cerr << "[ ";
    for (auto i : v)
    {
        _print(i);
        cerr << " ";
    }
    cerr << "]";
}

void solve(){
    int size;
    cin >> size;
    vector<int> v(size);
    int totalWin = 0;
    for(int i=0; i<size; i++){
        cin >> v[i];
        totalWin += v[i];
    }
    cout << (totalWin > size-1 ? "YES" : "NO") << '\n';
}

int main(){
    fast_io;
    int t;
    cin >> t;
    while (t--)
    solve();
    return 0;
}